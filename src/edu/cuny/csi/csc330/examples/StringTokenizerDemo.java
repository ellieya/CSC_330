/**
 * This Class demonstrates the usefulness of the StringTokenizer Class (java.util.)
 * 
 * It provides support for parsing CSV records ... very common file data format.
 * StringTokenizer is a very EASY Class to use.  
 * 
 * Piece-Parts:
 *     - List of CSV Record 
 *     - A Field Delimiter (e.g., "," ) 
 *     - Fields for each record ... 
 * 
 */
package edu.cuny.csi.csc330.examples;


import java.util.*;

public class StringTokenizerDemo {
	
	// default 
	private static final String  DEFAULT_FIELD_DELIMITER = "|";
	
	// one and only data property 
	private String fieldDelimiter;  
	

	public String getFieldDelimiter() {
		return fieldDelimiter;
	}
	public void setFieldDelimiter(String fieldDelimiter) {
		this.fieldDelimiter = fieldDelimiter;
	}

	public StringTokenizerDemo() {
		init();  
	}
	// called by constructor 
	private void init() {
		fieldDelimiter = DEFAULT_FIELD_DELIMITER; 
	}
	
	/**
	 * run the demo using the records that were passed in via the command line 
	 * @param records
	 */
	public void runDemo(String [] records ) {
		
		System.out.printf("---- Splitting records by '%s' -----\n", this.fieldDelimiter);
		
		// Record by Record 
		for(int i = 0 ; i < records.length ; ++i ) { 
			
			StringTokenizer tokenizer = new StringTokenizer(records[i], fieldDelimiter);
			
			int fcount = 0; 
			//  Field by Field 
			while (tokenizer.hasMoreElements()) {
				String field = tokenizer.nextToken(); 
				System.out.printf( "[%d] [%d]  %s\n", i+1, fcount+1, field  ); 
				++fcount; 
			}
			
			System.out.println( "\n"  );
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// if there are no command line args, do nothing and leave early 
		if(args.length == 0 ) {
			System.err.println("Can't demo without command line args");
			System.exit(0);
		}
		
		StringTokenizerDemo demo = new StringTokenizerDemo(); 
		
		// look for a field delimiter override from properties  ....
		String newDelimiter = System.getProperty("delimiter");
		if(newDelimiter != null && newDelimiter.length() > 0 )
			demo.setFieldDelimiter(newDelimiter); 
		
		// run demo 
		demo.runDemo(args); 

	}

}
