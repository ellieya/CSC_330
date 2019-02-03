package edu.cuny.csi.csc330.recursion;

import java.util.*;

/**
 * To be used as a tool to understand recursion .... 
 */
public class Factorial {

	// Default Constructor 
	public Factorial() {
		
	}
	
	public int factorial(int num ) 
	{
		return factorial(num, false);
	}
	
	public int factorial(int num, boolean debug) 
	{ 
		 int rv = 0;
		 
		 // Base Case - where we DON'T self-call the method ... 
		 if (num == 1)  {
			 if(debug) System.out.println("\nBASE CASE: num = 1\n");
			 rv = 1; 
		 }
		 // Solve the problem in steps - Num * fact( num - 1) - exactly as you would do it manually
		 else {
			 if(debug) System.out.println("num != 1:  " + num);
			 rv = num * factorial(num - 1, debug); 
		 }
		 
		 // THIS ONLY OCCURS IN BASE BASE - THAT IS, WE'RE POPPING OFF THE STACK
		 if(debug) 
			 System.out.println("Return Value " + rv);
		 
		 // . . . .  3 2 1 
		 return rv; 
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// default n value ... 
		int num = 5; 
		boolean debug = false; 
		
		String prop = System.getProperty("DEBUG");
		if(prop != null && prop.equalsIgnoreCase("true")) 
			debug = true; 
		
		if( args.length > 0) 
			num = Integer.parseInt(args[0]);
	
		System.out.println(new Date());
		Factorial fact = new Factorial();
		
		// call recusrsively implemented method 
		int factValue = fact.factorial(num, debug);
		
		System.out.printf("\nFact %d: %d\n", num, factValue);
		System.exit(0);
		
	}

}

