package edu.cuny.csi.csc330.recursion;

import java.util.*;

/**
 * To be used as a tool to understand recursion .... 
 */
public class Power {

	// Default Constructor 
	public Power() {
	
	}
	
	public double pow(double num, double exp) 
	{
		return pow(num, exp, false);
	}
	
	public double pow(double num, double exp, boolean debug) 
	{
	
		 // keep breaking it down ... 
		 if (exp > 0)  {
			 if(debug) System.out.printf("Calling pow(): exp = %.1f\n", exp);
			 return num * pow(num, exp -1, debug );
		 }
		 // base case 
		 else {
			 if(debug) System.out.printf("Base Case: exp = %.1f\n", 1.0);
			 return 1.0; 
		 }

		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// default n value ... 
		double num = 5; 
		double exp = 4;
		boolean debug = false; 
		
		String prop = System.getProperty("DEBUG");
		if(prop != null && prop.equalsIgnoreCase("true")) 
			debug = true; 
		
		if( args.length == 2 )  { 
			num = Double.parseDouble(args[0]);
			exp = Double.parseDouble(args[1]);
		}
	
		Power power = new Power();
		
		// call recusrsively implemented method 
		double powerResult = power.pow(num, exp, debug);
		
		System.out.printf("\nPower Result %.1f: %.1f %,.1f\n", num, exp, powerResult);
		System.exit(0);
		
	}

}

