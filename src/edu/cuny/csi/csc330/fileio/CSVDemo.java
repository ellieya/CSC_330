package edu.cuny.csi.csc330.fileio;

import java.io.*;
import java.util.*;

public class CSVDemo extends BaseSerializer {

	private final String DELIMITER = "|";
	private final String DEFAULT_READ_FILE = "C:/tmp/personRead.csv";
	private final String DEFAULT_WRITE_FILE = "C:/tmp/personWrite.csv";

	public CSVDemo() {
		// TODO Auto-generated constructor stub
	}
	

	
	private void writeCSV() throws IOException {
		  Person person = createDummyObject();
		
		  FileOutputStream fileOut = new FileOutputStream(DEFAULT_WRITE_FILE);
    	  BufferedOutputStream bufferedOut = new BufferedOutputStream(fileOut); 
	      PrintStream printStream = new PrintStream(bufferedOut);
	      
	      printStream.println( person.toCSVString("|") ); // what we've all used from System.out 
	      
	      printStream.close();

	}


	private void readCSV() throws IOException {

		// ////////////////////////////////////////////////
		// PARSE A CSV FILE ...
		// csv file containing data
		String strFile = DEFAULT_READ_FILE;

		// create BufferedReader to read csv file
		BufferedReader br = new BufferedReader(new FileReader(strFile));
		
		String record = "";
		StringTokenizer st = null;
		
		Person person;
		
		List<String> tokenList = new ArrayList<String>();
		List<Person> people = new ArrayList<Person>();
		int lineNumber = 0;

		// read comma separated file line by line
		while ((record = br.readLine()) != null) {
			lineNumber++;

			// break comma separated line using ","
			st = new StringTokenizer(record, DELIMITER);

			// gather up fields
			while (st.hasMoreTokens()) {
				// add field to list
				tokenList.add(st.nextToken());
				// System.out.println(tokenList);
			}

			person = createDummyObject(tokenList);
			people.add(person);
			tokenList.clear();

		}

		System.out.println(people);

	}

	private void run() {

		try {
			
			readCSV();
			
			writeCSV(); 
			
		} catch (IOException e) {
			System.out.println("IOException while reading csv file: " + e);
		}

	}

	public static void main(String[] args) {
		CSVDemo demo = new CSVDemo();
		demo.run();
	}

}
