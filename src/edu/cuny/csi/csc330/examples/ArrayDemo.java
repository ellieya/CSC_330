/**
 * Demonstrates Java array usage ... 
 */
package edu.cuny.csi.csc330.examples;

import java.util.Arrays;


// import org.json.simple.*;

public class ArrayDemo {

	public ArrayDemo() {
		 
	}
	
	protected static void displayArray(Object [] array ) {
		for(int i = 0 ; i < array.length ; ++i ) {
			System.out.println(array[i]);
		}
		System.out.println("");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int myArray[] = new int[5]; // 5 ints
		int myOtherArray[] = {1, 4, 9, 16, 25}; // populated
		
		String languages[] = {"C++", "Java", "Python", "PHP"};
		
		System.out.println(Arrays.toString(myOtherArray));
		
		displayArray( languages); 

		Person[] array; // no memory allocated yet …
		 

		// array of 4 references to Animal 
		array = new Person[4]; // Again, no memory yet
		
		displayArray( array); 
		     
		/* here we have a completely initialized Class Instance array of Animals  */
		for(int i=0 ; i < array.length ; i++) {
			array[i] = new Person();
		}

		displayArray( array); 
		
		
		//int x = 10 / 0;

	}

}
