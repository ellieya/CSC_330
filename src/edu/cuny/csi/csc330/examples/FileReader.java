/**
 * Shows 1 of MANY ways of reading from a file  ... 
 * 
 */
package edu.cuny.csi.csc330.examples;

import java.io.*;
import java.util.*;

public class FileReader {
	
	protected final static String DEFAULT_FILE_NAME = "C://tmp//SomeOtherFile.txt";
	private String fileName;
	

	public String getFileName() {
		return fileName;
	}

	public FileReader() {
		fileName = DEFAULT_FILE_NAME; 
	}
	
	public FileReader(String fileName) {
		this.fileName = fileName; 
	}


 
	@Override
	public String toString() {
		return "FileWriter [fileName=" + fileName + "]";
	}

	
	/**
	 * 
	 * @return
	 */
	public  String  readFrom() {
			StringBuilder stringBuilder = new StringBuilder(); 
			
		    try {
		    	java.io.FileReader fileReader = new java.io.FileReader(this.fileName);  
		    	BufferedReader bufferedReader = new BufferedReader(fileReader);
		    	String line; 
		    	while( ( line = bufferedReader.readLine() ) != null ) {
		            stringBuilder.append( line + "\n" );
		        }
			      
		    	fileReader.close();
	
		    } 
		    catch (Exception ex) {
			      System.err.println(ex );
		    }
		    
		    return stringBuilder.toString(); 
	}
	      
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileReader fileReader = new FileReader();
		System.out.println("Trying to read some data to a file: " + fileReader.getFileName()); 
		String data = fileReader.readFrom();
		System.out.println(data); 
		  
		System.out.println("Done - exiting"); 
		System.exit(0); 
	}
	




}
