package edu.cuny.csi.csc330.examples2;

import java.util.Arrays;

public class ParamDemo {
	
	protected static void tester(String ref,  Object... args) {
		
		System.out.println(args.length);
		
		for(int i = 0 ; i < args.length ; i++ ) {
			System.out.println(args[i]);
		}
		
		System.out.println("---------------------");
				
		for(Object obj : args) {
			System.out.println(obj);
		}
		
		System.out.println("tester() exiting.\n\n");
		return; 
	}



	public static void main(String[] args) {
		
		tester("123"); 
		
		tester("789", "arg1", "arg2"); 

	}

}
