package edu.cuny.csi.csc330.recursion;

import java.util.*;

/**
 * To be used as a tool to understand recursion .... 
 */
public class Triangular {

	// Default Constructor 
	public Triangular() {
		
	}
	
	public int triangular(int num ) 
	{
		return triangular(num, false);
	}
	
	public int triangular(int num, boolean debug) 
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
			 rv = num + triangular(num - 1, debug); 
		 }
		 
		 // THIS ONLY OCCURS IN BASE BASE - THAT IS, WE'RE POPPING OFF THE STACK
		 if(debug) 
			 System.out.println("Return Value " + rv);
		 
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
		Triangular tri = new Triangular();
		
		// call recusrsively implemented method 
		int triValue = tri.triangular(num, debug);
		
		System.out.printf("\nTri %d: %d\n", num, triValue);
		System.exit(0);
		
	}

}

