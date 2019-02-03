/**
 * Interacting with a program from the command line and through std input ... 
 */
package edu.cuny.csi.csc330.examples;

import java.io.*;
import java.util.Scanner;

public class InteractiveDemo {
	
	private boolean debug = false; 
	private int someNumber = 99; 

	// Default Constructor 
	public InteractiveDemo() {
		// TODO Auto-generated constructor stub
	}
	
	// overloaded constructor 
	public InteractiveDemo(boolean debug) {
		this.debug = debug; 
	}
	
	
	public void doSomeWork(int limit) {
		
		System.out.printf("Using a limit of %d\n", limit); 
		
		for(int i = 0 ; i < limit ; ++ i) 
			; 
		
		// If we're in DEBUG Mode 
		if(debug)
			System.out.println(this);
		
	}

	

	@Override
	public String toString() {
		return "InteractiveDemo [debug=" + debug + ", someNumber=" + someNumber
				+ "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int limit = 100; 
		//       CHECK FOR COMMAND LINE PARAMETERS 
		// user passed at least 1 command line parameter 
		if(args.length > 0 ) {
			limit = Integer.parseInt(args[0]); 
		}
		
		//      CHECK FOR "PROPERTY" PASSED INTO THE JVM ... 
		//         Are we in DEBUG mode - yes or no?
		String debugValue = System.getProperty("DEBUG"); 
		System.out.println(debugValue); 
		boolean debug = false; 
		if(debugValue != null &&  debugValue.equalsIgnoreCase("YES") ) 
			debug=true;
		
		// create an instance of InteractiveDemo using a non-default constructor 
		InteractiveDemo demo = new InteractiveDemo(debug); 
		demo.doSomeWork(limit);
		
		// use an IO scanner to gather input from the user through System.in 
		System.out.print("Provide a number from 1 - " + limit + " : "); 
		Scanner scanner = new Scanner(System.in);
		limit = scanner.nextInt(); 
		
		System.out.println("You provided a limit of: "  + limit);
		
		demo.doSomeWork(limit);
		

	}

}
