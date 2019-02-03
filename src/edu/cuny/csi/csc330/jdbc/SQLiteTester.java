package edu.cuny.csi.csc330.jdbc;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement; 

public class SQLiteTester {

	public SQLiteTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 Connection connection = null;  
	     ResultSet resultSet = null;  
	     Statement statement = null;  
	     
	     int ecode = 0;

	     try   {  
	    	 
	         Class.forName("org.sqlite.JDBC");  
	         String dbURL = "jdbc:sqlite:C:\\data\\sqlite\\trackdb.sqlite"; 
	         
	         connection = DriverManager.getConnection(dbURL);  
	         statement = connection.createStatement();  

	         System.out.println(connection.getClass().getName());
	         System.out.println(statement.getClass().getName() + "\n\n\n");
	         
	         
	         // Perform a SELECT on one of the tables ... 
	         
			
			statement = connection.createStatement() ;
			
			resultSet = statement.executeQuery( " SELECT * FROM Genre");
			 
			while(resultSet.next() ) {
				int id = resultSet.getInt(1); // ID
				String name = resultSet.getString(2);   // Name
				System.out.printf("%5d %s\n", id, name);
			}
			
			System.out.println("");
	         
	        		 
	     } 
	     catch (Exception e) 
	     {  
	         e.printStackTrace();  
	         ecode = 9;
	     }
		
		System.exit(ecode);
		
		
		/*
		 SHOULD SEE OUTPUT THAT LOOKS SOMETHING LIKE THIS:
		    org.sqlite.SQLiteConnection
			org.sqlite.jdbc4.JDBC4Statement
			
			
			
			    1 Rock
			    2 Industrial
			    3 Soundtrack
			    6 Funk
			    9 Metal
			   14 Blues/R&B
			   23 Easy Listening
			   95 Country
			  103 Gospel & Religious
			  118 New Age
			  131 Jazz
			  132 Alternative & Punk
			  147 Business
			  150 Nonfiction
			  155 Classical
			  169 Drama
			  170 Electronic
			  171 Holiday
			  183 Alternative
			  195 Podcast
			  229 Folk
			  249 Speech
			  279 Reality TV
			  295 Comedy
			  302 Dance & Electronic
		 */
		
		
	}

}
