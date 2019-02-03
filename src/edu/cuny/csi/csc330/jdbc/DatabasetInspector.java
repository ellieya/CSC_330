package edu.cuny.csi.csc330.jdbc;

import java.sql.*;
import java.util.*;


/**
 * DB Inspector: will try to open a connection to a given data source and:
 * 1) gather a list of tables  
 * 2) describe the  "schema" of each table 
 * 3) pull N number of records from each table, or of each table specified.  
 * 4) Save/cache db metadata for later use ... 
 * 
 * @author P98955
 *
 */
public  class DatabasetInspector {

	private static final int DEFAULT_RESULTSET_LIMIT = 50;
	
	private String dsn;
	private boolean state;
	private boolean debug;
	private int resultSetLimit;
	
	// overload this Set through -Dtables=a,b,c,d,,e 
	private Set<String> tables;
	
	private String exportFileName;
	
	
	private Map<String, List> tableFieldTypes;
	private Map<String, List> tableFieldSizes;
	private Map<String, List> tableFieldNames;
	
	private Map<String, Integer> tableRowCounts;
	

	private Connection connection;

	public DatabasetInspector() throws Exception {
		init();
	}

	public DatabasetInspector(String dsn) throws Exception {
		super();
		this.dsn = dsn;
		init();
	}
	
	
	
	
	@Override
	public String toString() {
		return "DatabaseInspector [dsn=" + dsn + ", state=" + state;
	}

	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
		
	}

	/**
	 * 
	 * @param tableList
	 * @return
	 */
	protected Set transformCSV2Set(String tableList)  {
		// System.out.println("In transformCSV2Set() ... ");
		
		StringTokenizer st = new StringTokenizer(tableList, ",");
		Set<String>set = new TreeSet<String>();
		
		while(st.hasMoreElements()) {
			String table = st.nextToken(); 
			set.add(table); 
		}
		
		return set;  
	}

	protected void init() throws Exception {
		
		resultSetLimit = DEFAULT_RESULTSET_LIMIT; 

		tables = new TreeSet<String>();
		tableFieldNames = new HashMap<String, List>(879);
		tableFieldSizes = new HashMap<String, List>(879);
		tableFieldTypes = new HashMap<String, List>(879);
		tableRowCounts = new HashMap<String, Integer>(879);
		

		String debugFlag = System.getProperty("DEBUG");
		if ("TRUE".equalsIgnoreCase(debugFlag))
			debug = true;
		
		String resultSetLimitValue = System.getProperty("RESULTSET_LIMIT");
		if (resultSetLimitValue != null && resultSetLimitValue.length() > 0 ) {
			resultSetLimit  = Integer.parseInt(resultSetLimitValue); 
		}
		
		//// !!!!!  Pre-populate tables Set 
		String tableList = System.getProperty("TABLE_LIST");
		if (tableList != null && tableList.length() > 0 ) {
			tables = transformCSV2Set(tableList); 
		}
			

		obtainConnection();

		state = true;

	}

	
	/**
	 * 
	 * @throws Exception
	 */
	protected void obtainConnection() throws Exception  {
		ResourceBundle dsnBundle = ResourceBundle.getBundle(dsn);

		String dbDriver = dsnBundle.getString("DS_DRIVER");
		String dbURL = dsnBundle.getString("DS_NAME");

		try {
			
			Class.forName(dbDriver);
			
			if(connection != null) 
				connection.close(); 
			
			// connection = DriverManager.getConnection(dbURL, "", "");
			
			connection = DriverManager.getConnection(dbURL);
			
		} catch (SQLException ex) {
			System.out.println("init() Failed to connect: " + ex);
			throw ex;
		}
		
		return ;
	}

	public boolean isState() {
		return state;
	}

	
	
	/**
	 * - connect - derive sorted set of tabes - perform a record count query per
	 * table - list field-name, type, size of all elememts in each table
	 */
	public void inspect() {

		try {

			DatabaseMetaData meta = connection.getMetaData();
			ResultSet res = meta.getTables(null, null, null,
					new String[] { "TABLE" });

			System.out.println("******************  LIST OF TABLES *****************");

			
			if(tables.size() ==  0 ) {
				while (res.next()) {
					String table = res.getString("TABLE_NAME");
					tables.add(table.toUpperCase());
	
					if (debug) {
						System.out.println("   " + res.getString("TABLE_CAT")
								+ ", " + res.getString("TABLE_SCHEM") + ", "
								+ table + ", " + res.getString("TABLE_TYPE") + ", "
								+ res.getString("REMARKS"));
					}
	
				}

				res.close();
				
			}

			for (String table : tables) {
				
				int rows = this.getTableRowCount(table);
				this.tableRowCounts.put(table, rows);
				
				System.out.printf("%s (%d records)\n", table, rows);

				if (rows < 1) {
					System.out.println("No Data\n");
					continue;
				}

				ResultSet resultSet = meta.getColumns(null, null, table,  null);
				
				List<String> fields = new ArrayList<String>(100);
				List<String> types = new ArrayList<String>(100);
				List<Integer> sizes = new ArrayList<Integer>(100);
				System.out.printf(
						"%24s  %10s  %10s\n", 
						"Field Name", "Data Type", "Size");
				while (resultSet.next()) {
					String name = resultSet.getString("COLUMN_NAME");
					String type = resultSet.getString("TYPE_NAME");
					int size = resultSet.getInt("COLUMN_SIZE");

					
					System.out.printf(
							"%24s  %10s  %10d\n", 
							name, type, size);

					fields.add(name); 
					types.add(type); 
					sizes.add(size); 
					
				}
				
				System.out.println("");
				
				tableFieldNames.put(table, fields); 
				tableFieldSizes.put(table, sizes); 
				tableFieldTypes.put(table, types); 
			}
			
			System.out.println("******************************************************");

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	protected String listToCSV(List<String> list) {
		boolean started = false; 
		StringBuffer buffer = new StringBuffer(2048); 
		for(String ele :  list)  {
			if(started == true) 
				buffer.append(","); 
			buffer.append(ele);
			started = true; 
		}
		return buffer.toString();
	}

	
	/**
	 * 
	 * @param tableName
	 * @return
	 */
	protected int getTableRowCount(String tableName) {

		int count = -1;

		String sql = "SELECT COUNT(*) AS rowcount FROM " + tableName;

		try {
			Statement s = connection.createStatement();

			ResultSet r = s.executeQuery(sql);
			r.next();
			count = r.getInt("rowcount");
			r.close();
		} catch (SQLException ex) {
			System.err.printf("getTableRowCount()  %s   %s\n ", sql, ex);
		}

		return count;

	}
	
	

	
	
	
	/**
	 * extract some N number of records from each table that carries
	 *  > 0 records 
	 */
	public void export() throws Exception  {
		
		String limit = "";
		
		if(resultSetLimit > 0)
			limit = String.format("LIMIT %d",  resultSetLimit );  
		
		
		
		// obtainConnection();

		
		// SELECT TOP resultSetLimit  field-list FROM TABLE 
		
		////////////////////////////////////////////
		// iterate over tables 
		for(String table : tables) {
			
			// reset connection
			obtainConnection();
			
			List<String> fields = this.tableFieldNames.get(table); 
			if(fields == null) 
				continue;
			
			String fieldString = this.listToCSV(fields);
			
			String sql = String.format("SELECT %s FROM %s %S",
					fieldString, table, limit); 
			
			System.out.println("\n" + sql );
			
			try { 
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				
				presentData(table,  resultSet ) ;
			

				resultSet.close();
				statement.close();
				
				
			}
			catch(SQLException ex ) {
				System.err.println("export(): " + table + "\n" + ex + " : " + ex.getStackTrace());
				System.err.flush();
				// return; 
			}
			
			// fetch from DB 
			
		}


	}
	
	
	/**
	 * 
	 * @param table
	 * @param resultSet
	 * @throws SQLException
	 */
	protected void presentData(String table, ResultSet resultSet) throws SQLException  {
		// iterate over records 
		int rownum = 1; // 
		while(resultSet.next()  ) { 
			 
			// iterate over cols 
			String tableLable = table; 
			for(int col = 1 ; col <= resultSet.getMetaData().getColumnCount() ; ++col ) {
				
				String colName = resultSet.getMetaData().getColumnName(col) ;
				  
				Object object = resultSet.getObject(colName); 
				System.out.printf(" %-20s\t[%2d][%2d]: %18s: %s\n", tableLable, rownum, col, colName, object);
				tableLable = ""; 
			}
			
			System.out.printf("\n");
				
			++rownum; 
		}
	}
	
	
		
	/**
	 * 
	 */
	public void report() {

		System.out.printf("%30s\n%20s Contains %d Tables\n\n", "TABLE SUMMARY", dsn, tables.size());

		System.out.printf("  %-25s %s\n", "TABLE", "NO. OF RECORDS");
		for (String table : tables) {
			System.out.printf("%-30s %6d\n", table,
					this.tableRowCounts.get(table));
		}

	}
	
	
	public static void main(String[] args) throws Exception {

		// Default DSN Name
		ResourceBundle dsnBundle = ResourceBundle.getBundle("DSN");
		String dsn = dsnBundle.getString("DATA_SOURCE");
		


		DatabasetInspector inspector = new DatabasetInspector(dsn );

		if (inspector.isState()) {

			
			System.out.println(inspector);
			
			inspector.inspect();

			inspector.report();
			
			inspector.export(); 
		}
		
		System.out.println(inspector.getClass().getName() +   ": is all done");

	}



}
