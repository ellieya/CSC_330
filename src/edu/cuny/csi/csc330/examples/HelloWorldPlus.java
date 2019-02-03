/*
 * a step above HelloWorld! 
 */
package edu.cuny.csi.csc330.examples;

import java.util.*;

public class HelloWorldPlus {
	private String []  args; 
	
	/*
	 * Constructor that takes an array of String Objects 
	 */
	public HelloWorldPlus(String[] args) {
		this.args = args; 
	}
	
	/*
	 * 
	 */
	public void displayArgs() {
		for(int i = 0 ; i < args.length ; ++ i) {
			System.out.printf("%s\n", args[i]);
		}
		return;
	}
	


	/**
	 * main() is always the entry point of a program ... 
	 * Can't run class as standalone program without it 
	 */
	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.err.println("HelloWorldPlus: requires at least 1 arguments - exiting early."  ); 
			System.exit(1); 
		}
		
		// create an instance of HelloWorldPlus  pass in command line argument String Array 
		HelloWorldPlus hwp = new HelloWorldPlus(args); 
		hwp.displayArgs(); 
		 
		System.exit(0); 
	}

}
