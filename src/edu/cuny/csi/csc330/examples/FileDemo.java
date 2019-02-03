/**
 * Dealing with the file system
 * And a brief introduction to Exception handling ... 
 */
package edu.cuny.csi.csc330.examples;

import java.io.*;

public class FileDemo {

	public FileDemo() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dirName = "C://tmp//CSC330";
		String fileName = dirName + "//tester.txt";
		
		File directory = new File(dirName);
		File theFile = new File(fileName);
		
		System.out.println("Checking");
		
		// Does dir exist ? 
		if(directory.exists() == false) {
			// if not created it! 
			if(directory.mkdir() ) { // if we succeed in creating dir, create an empty file
				System.out.println("created " + directory);
				try {  // exception handling!  
					theFile.createNewFile();
					System.out.println("created " + theFile);
				}
				catch(IOException ex) {
					System.err.println(ex);
				}
			}
			else {
				System.err.println("Could not create: " + dirName );
			}
		}
		
		File [] files = directory.listFiles(); 
		System.out.println("\nFile listing under directory: " + directory.getAbsolutePath() );
		for(File file : files) {  // should be read as, "for each file in file"
		    System.out.println(file);
		}
		
		

	}

}
