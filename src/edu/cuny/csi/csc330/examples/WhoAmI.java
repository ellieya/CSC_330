/**
 * Object is always the "root" super class 
 * 
 *  this 
 *  super 
 *  The "Class" Class 
 */
package edu.cuny.csi.csc330.examples;

public class WhoAmI {
	
	/**
	 * displays information about the current instance of "WhoAmI" 
	 */
	public void aboutMe() {
		
		// demonstrates something called "introspection" - simple introspection 
		Class myClass = this.getClass(); 
		String myClassName = myClass.getName();
		System.out.println("My Class Name: " + myClassName); 
		
		System.out.println("My Super Class' Name:  " + myClass.getSuperclass().getName()); 
		
	}

	public WhoAmI() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WhoAmI whoAmI = new WhoAmI(); 
		
		whoAmI.aboutMe(); 

	}

}
