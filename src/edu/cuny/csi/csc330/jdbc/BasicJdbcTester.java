package edu.cuny.csi.csc330.jdbc;

import java.sql.*;
import java.text.*;
import java.util.*;

public class BasicJdbcTester {
	
	private static String url; 
	private static Connection connection;
	
	static {
		url = "jdbc:mysql://localhost/vir?user=root&password=wereno1"; 
		connection = null; 
	}
	
	public static void init() throws SQLException {
		
		connection = DriverManager.getConnection(url);
		
	}
	
	public static void closeOut() throws SQLException {
		
		connection.close();
		
	}
	
	
	public static void queryTest(String query) throws SQLException {

		Statement statement = null;
		ResultSet resultSet = null; 
		
		statement = connection.createStatement() ;
		System.out.println("Executing Query: " + query ); 
		resultSet = statement.executeQuery( query );
		 
		while(resultSet.next() ) {
			int id = resultSet.getInt(1); // ID
			String name = resultSet.getString(2); // datetime 
			System.out.printf("%5d %s\n", id, name);
		}
		
		System.out.println("");
		
	}
	
	
	public static void deleteTest() throws SQLException {

		Statement statement = null;
		Statement dstatement = null;
		ResultSet resultSet = null; 
		String query = "SELECT * FROM test_record WHERE id = 4557"; 
		
		String delete = "DELETE FROM test_record WHERE id = 4557";
		
		dstatement = connection.createStatement() ;
		
		int records = dstatement.executeUpdate(delete);
		System.out.printf("DELETE Affected %d records\n", records);
		
		statement = connection.createStatement() ;
		System.out.println("Executing Query: " + query ); 
		resultSet = statement.executeQuery( query );
		 
		while(resultSet.next() ) {
			int id = resultSet.getInt(1); // ID
			String comment  = resultSet.getString("comment"); // Comment 
			java.util.Date date = resultSet.getDate(3); // datetime 
			// SHOULD NOT DISPLAY ... 
			System.out.printf("%5d %s %s\n", id, comment, date); 
		}
		System.out.println("");
		
	}
	
	
	public static void updateTest() throws SQLException {

		Statement statement = null;
		Statement ustatement = null;
		ResultSet resultSet = null; 
		String query = "SELECT * FROM test_record WHERE id = 3293"; 
		
		String update = "UPDATE test_record SET comment = 'Andrew S' WHERE id = 3293 ";
		
		ustatement = connection.createStatement() ;
		
		ustatement.executeUpdate(update);
		
		statement = connection.createStatement() ;
		System.out.println("Executing Query: " + query ); 
		resultSet = statement.executeQuery( query );
		 
		while(resultSet.next() ) {
			int id = resultSet.getInt(1); // ID
			String comment  = resultSet.getString("comment"); // Comment 
			java.util.Date date = resultSet.getDate(3); // datetime 
			System.out.printf("%5d %s %s\n", id, comment, date); 
		}
		
		System.out.println("");
		
	}

	
	public static void insertTest() throws SQLException {

		Statement statement = null;
		Statement istatement = null;
		ResultSet resultSet = null; 
		String query = "SELECT * FROM test_record"; 
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		Calendar cal = Calendar.getInstance();  
		
		int rid = ( ( (int) ( Math.random() * 100000000 ) % 10000) + 1 );
		String insert = "INSERT INTO test_record " + 
		         "VALUES (" + rid + ", 'net.dapex.vir.testing.BasicJdbctester', '"  + 
				                   dateFormat.format(cal.getTime()) + "')";
		
		istatement = connection.createStatement() ;
		
		istatement.executeUpdate(insert);
		
		statement = connection.createStatement() ;
		System.out.println("Executing Query: " + query ); 
		resultSet = statement.executeQuery( query );
		 
		while(resultSet.next() ) {
			int id = resultSet.getInt(1); // ID
			String comment  = resultSet.getString("comment"); // Comment 
			java.util.Date date = resultSet.getDate(3); // datetime 
			System.out.printf("%5d %s %s\n", id, comment, date); 
		}
		
		System.out.println("");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int exitCode = 0;
		
		////////////////////////////////////////////////////////////
		///  How we would create instance of BasicJdbcTester
		/// BasicJdbcTester tester = new BasicJdbcTester();  
		/////////////////////////////////////////////////////////// 
		
		try {
			init(); 
			
			insertTest();
			
			updateTest();
			
			deleteTest(); //  EXCEPTION THROWN <<<<<<<<<<<<<<<<<<<<<<<<<<<--------------------------   
			
			String query = "SELECT * FROM security_group"; 
			queryTest(query);
			
			query = "SELECT * FROM user_profile"; 
			queryTest(query);
			
		}
		catch(SQLException ex ) {
			System.err.println("DB Exception: " + ex); 
			exitCode = ex.getErrorCode(); 
		}
		finally {
			try { closeOut(); } catch(SQLException ex) { ; }
		}

		System.out.println("Exit Code: " + exitCode);
		System.exit(exitCode); 

	}

}
