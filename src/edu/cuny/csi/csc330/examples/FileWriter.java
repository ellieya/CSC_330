/**
 * Shows 1 of MANY ways to write data to a file ... using a PrintStream
 * NOTE: System.out is an instance of PrintStream 
 * 
 */
package edu.cuny.csi.csc330.examples;

import java.io.*;
import java.util.*;

public class FileWriter {
	
	protected final static String DEFAULT_FILE_NAME = "C://tmp//WriteFile.txt";
	private String fileName;
	

	public FileWriter() {
		fileName = DEFAULT_FILE_NAME; 
	}
	
	public FileWriter(String fileName) {
		this.fileName = fileName; 
	}


 
	@Override
	public String toString() {
		return "FileWriter [fileName=" + fileName + "]";
	}

	/** 
	 * NOTE: we just "overloaded" the public writeTo() method with a different signature 
	 * @param aFile
	 * @param data
	 * @param append
	 */
	protected  void writeTo(File aFile, String data, boolean append) {
		
		    try {
		    	  FileOutputStream fileOut = new FileOutputStream(aFile, append);
		    	  BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut); 
			      PrintStream printStream = new PrintStream(bufferedOut);
			      
			      printStream.println(data); // what we've all used with System.out 
			      
			      printStream.close();
	
		    } 
		    catch (Exception ex) {
			      System.err.println(ex );
		    }
		    
	}
	  
	/**
	   * Writes "data" to file assigned to this Class - 
	   * control whether files gets over-written with "append" flag 
	   * @param data
	   * @param append
	*/
	public void writeTo(String data, boolean append) {
		  File file = new File(fileName);
		  // call "internal" method of the same name 
		  writeTo(file,  data,  append);
	}
		    
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileWriter fileWriter = new FileWriter();
		System.out.println("Trying to write some data to a file."); 
		fileWriter.writeTo( "1st Line of Data" , false);
		fileWriter.writeTo( "2nd Line of Data" , true);
		
		System.out.println("Trying to write some data to another file."); 
		fileWriter = new FileWriter("C://tmp/SomeOtherFile.txt");
		fileWriter.writeTo( "Two + Two = " , false);
		Integer i = new Integer(2 + 2); 
		fileWriter.writeTo( i.toString()  , true);
		  
		System.out.println("Done - exiting"); 
		System.exit(0); 
	}
	




}
