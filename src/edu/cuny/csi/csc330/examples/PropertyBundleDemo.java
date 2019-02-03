/**
 * PropertyResourceBundle 
 * This is a very simple example of using a property bundle to provide 
 *  prompts / messages used by a program.
 * Thus, we decouple human readable text from compiled source code ... a fundamental best-practice
 * in any programming langauge ... 
 */
package edu.cuny.csi.csc330.examples;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PropertyBundleDemo {
	
	static {
		initFromPropBundle(); 
	}
	
	private static void initFromPropBundle() {
		// so we're expecting a file in our CLASSPATH called PropertyBundleDemo.properties
		ResourceBundle bundle = ResourceBundle.getBundle("PropertyBundleDemo");
		
		if ( bundle.containsKey("PROMPT") ) {
			prompt = bundle.getString("PROMPT");
		}
		
		if ( bundle.containsKey("ERROR_MESSAGE") ) {
			errorMessage = bundle.getString("ERROR_MESSAGE");
		}
		
		if ( bundle.containsKey("SUCCESS_MESSAGE") ) {
			successMessage = bundle.getString("SUCCESS_MESSAGE");
		}

		
	}
	
	
	protected static String prompt;
	protected static String errorMessage;
	protected static String successMessage;

	// default constructor 
	public PropertyBundleDemo() {
	}

	/**
	 * returns 0 if value is not numeric 
	 * @param value
	 * @return
	 */
	public int validateNumbericValue(String value)  
	{  
		  int number; 
		  try  
		  {  
		    number = Integer.parseInt(value);  
		  }  
		  catch(NumberFormatException ex)  
		  {  
		    return 0;  
		  }  
		  return number;  
	}
	
	public void runDemo( ) {
		System.out.print(prompt); 
		Scanner scanner = new Scanner(System.in);
		String response = scanner.next(); 
		int number = validateNumbericValue(response);  
		
		if(number == 0 ) {
			System.err.println(errorMessage); 
		}
		else {
			System.out.println(successMessage + (number * number ) ); 
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// new instance 
		PropertyBundleDemo demo = new PropertyBundleDemo(); 
		
		// run demo 
		demo.runDemo(); 

	}

}
