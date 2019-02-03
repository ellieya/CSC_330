/**
 * Demonstrates the "Iterator" Interface implemented by ALL collections 
 */

package edu.cuny.csi.csc330.examples;

import java.util.*;


public class IteratorDemo {
	
	private List list;
	
	
	public IteratorDemo() {
		init();  
	}
	
	
	private void init() {
		list = new ArrayList(); 
	}
	
	public void demo() {
		
		// populate list with Integers 
		for(int i = 1 ; i <= 32 ; ++i ) {
			list.add(new Integer(i * i)); 
		}
		
		System.out.println("Size of List instance: " + list.size()); 
		
		// All implementations of Collection implement the Iterator Interface 
		int sum = 0; 
		Iterator it = list.iterator();
		while(it.hasNext() ) { 
			Integer i = (Integer) it.next();  // needs to be casted to real object ... 
			System.out.println(i); 
			sum = sum + i.intValue();
		}
		System.out.println("Sum: " + sum + "\n");

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IteratorDemo starter = new IteratorDemo(); 
		
		starter.demo(); 

	}

}
