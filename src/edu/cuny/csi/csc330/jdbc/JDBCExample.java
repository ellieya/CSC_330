package edu.cuny.csi.csc330.jdbc;

import java.sql.*;

public class JDBCExample {

	public JDBCExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			int exitCode = 0;
		
			String url = "jdbc:mysql://localhost/world?user=root&password=wereno1"; 
			
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null; 
			String query = "SELECT Code, Name, Continent, Region FROM country ORDER BY Name"; 
			
			try {
				
				connection = DriverManager.getConnection(url);
				System.out.println(connection.getClass().getName() + " implements Connection");
				statement = connection.createStatement() ;
				System.out.println(statement.getClass().getName() + " implements Statement");
				resultSet = statement.executeQuery( query );
				System.out.println(resultSet.getClass().getName() + " implements ResultSet\n" );
				
				while(resultSet.next()) {
					String name = resultSet.getString(3); // get 3rd field of the result set record. 
					String continent = resultSet.getString(2); // get 3rd field of the result set record. 
					System.out.printf("%s / %s\n",  continent, name);
				}
				
			}
			catch(SQLException ex ) {
				System.err.println("DB Exception: " + ex); 
				exitCode = ex.getErrorCode(); 
			}
			finally {
				try {
					if(statement != null ) statement.close(); 
					if(connection != null) connection.close(); 
					if(resultSet != null) resultSet.close(); 
				}
				catch(SQLException ex ) {} 
				
			}

			System.out.println("Exit Code: " + exitCode);
			System.exit(exitCode); 
	}

}
