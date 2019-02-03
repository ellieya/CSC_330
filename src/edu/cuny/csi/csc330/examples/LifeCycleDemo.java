/**
 * VERY IMPORTANT 
 * 
 * THE BASICS PRESENTED IN THIS CLASS AND ReferenceDemo WILL EASILY MAKE UP 10% OF MIDTERM & FINAL
 * 
 * Demonstrates the lifecycle of a Class - and multiple instances thereof 
 */

package edu.cuny.csi.csc330.examples;

import java.util.*; 

public class LifeCycleDemo {
	
	/**
	 * This block gets called only once - when Class Loader first encounters the LifeCycleDemo
				Class 
	*/
	static {
		instanceCounter = 0; 
		System.out.println("LifeCycleDemo class is now loaded"); 
	}
	
	static protected int instanceCounter;  
	static protected Date firstCreatedTime;  
	static protected Date mostRecentCreatedTime;
	
	/**
	 * "utility method to pause execution of a program thread by N seconds ... 
	 */
	static protected void pause(int seconds) {
		try {
		    Thread.sleep(seconds * 1000); //  Thread.sleep works in milliseconds .... 
		} 
		catch(InterruptedException ex) {
		    ;
		}
	}
	
	
	private String name; 
	
	// default constructor 
	public LifeCycleDemo() {
		init(); 
	}
	// another constructor 
	public LifeCycleDemo(String name) {
		this.name = name; 
		init(); 
	}
	
	/**
	 * Display stat info ab out LifeCycleDemo Class 
	 */
	static public void displayClassStats() {
		System.out.println("---------------------------------------------"); 
		System.out.println("First Instance Created: " + firstCreatedTime); 
		System.out.printf("current instanceCounter = %d\n", instanceCounter); 
		System.out.println("Most Recent Instance Created: " + mostRecentCreatedTime); 
		System.out.println("---------------------------------------------\n");
	}
	
	
	public String toString() {
		return "LifeCycleDemo [name=" + name + "] ";
	}

	
	private synchronized void init() {
		instanceCounter++;
		
		mostRecentCreatedTime =  new Date(); 
		
		// if this is our first instance ... 
		if(firstCreatedTime == null)
			firstCreatedTime = mostRecentCreatedTime ; 
		
	}
	
	// gets called when this instance gets GC-ed 
	protected synchronized void finalize() {
		
		instanceCounter--;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LifeCycleDemo demo;  
		
		LifeCycleDemo.displayClassStats(); 
		
		// 1st instance 
		demo = new LifeCycleDemo("instance 1"); 
		LifeCycleDemo.displayClassStats(); 
		LifeCycleDemo.pause(1); // wait one second 

		// 2nd instance 
		LifeCycleDemo demo2 = new LifeCycleDemo("instance 2"); 
		LifeCycleDemo.displayClassStats(); 
		
		LifeCycleDemo.pause(1); // wait one second 

		// 3rd instance 
		LifeCycleDemo demo3 = new LifeCycleDemo("instance 3"); 
		LifeCycleDemo.displayClassStats(); 
		
		LifeCycleDemo.pause(1); // wait one second 
		// 4th instance 
		LifeCycleDemo demo4	 = new LifeCycleDemo("instance 4"); 
		LifeCycleDemo.displayClassStats(); 
		
		/* 
		 * another reference now pointing at demo4 
		 */
		LifeCycleDemo demo4ref = demo4; 
		
		demo4 = null; // null out one of 2 references to the 4th instance 
		demo = null; // null out the only reference to 4th instance 
		
		// get rid of un-used instance (aka heap) memory 
		System.gc(); // "suggest" that the Garbage Collector be executed ... 
		LifeCycleDemo.pause(1); // wait one second - for good luck 
		
		LifeCycleDemo.displayClassStats(); // last stats display ... 
		
	}

}
