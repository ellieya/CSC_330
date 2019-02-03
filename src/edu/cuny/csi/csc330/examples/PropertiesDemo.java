/*
 * Demonstrates how to get at System properties .... 
 * And Env vars 
 */

package edu.cuny.csi.csc330.examples;

import java.util.*;

public class PropertiesDemo {

	public PropertiesDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// List all JVM System Properties
		Properties props = System.getProperties();
		System.out.println("PROPERTIES");
		for (String key : props.stringPropertyNames()) {
			System.out.println(key + " = " + props.getProperty(key));
		}

		System.out.println("\nENV VARs");
		// Example of getting a few env variables
		System.out.println("PATH: " + System.getenv("PATH"));
		System.out.println("CLASSPATH: " + System.getenv("CLASSPATH"));
		System.out.println("HOMEDRIVE: " + System.getenv("DRIVE"));

	}

}
