/**
 * What Core Java Classes can be used when the "immutable" String just doesn't cut it??
 * StringBuilder - better for J2SE 
 * StringBuffer - safer for multi-threaded J2EE 
 */

package edu.cuny.csi.csc330.examples;

public class StringBuilderDemo {

	public StringBuilderDemo() {
	 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Like most objects, has a default constructor  ... 
		StringBuilder stringBuilder = new StringBuilder(); 
		
		// preallocate some space - more efficient! 
		stringBuilder = new StringBuilder(4096); 
		
		// add some text 
		stringBuilder.append("\nABCDEFGHIJKXYZ"); 
		
		System.out.println(stringBuilder);
		
		// insert the missing part of the alphabet ... 
		stringBuilder.insert(11, "LMNOPQRSTUVW"); 
		
		System.out.println(stringBuilder);
		
		// add more ASCII characters on a separate line 
		stringBuilder.append(" \n0123456789=+-_*&^%$#@!"); 
		System.out.println(stringBuilder);
		
		// demo how replace can work ... 
		int start = stringBuilder.indexOf("0");
		int end = stringBuilder.indexOf("9") + 1;
		stringBuilder.replace(start, end, "NEW VALUES");
		
		System.out.println(stringBuilder);
		
		// create 2nd StringBuilder initialized from a String  
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString().toLowerCase()); 
		
		// this instance should display as lower case 
		System.out.println(stringBuilder2.toString());
		
		System.exit(0); 
	}

}
