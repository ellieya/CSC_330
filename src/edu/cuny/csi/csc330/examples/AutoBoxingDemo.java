package edu.cuny.csi.csc330.examples;

/**
 * JDK1.5 introduced "autoboxing" for developer's convenience 
 * 
 *  *generics - "type" the elements contained in a given collection 
 *  *autoboxing - avoid the heavy lifting around converting primitive types to Wrapper Classses 
 *  
 * 
 */


import java.util.*;


public class AutoBoxingDemo {
	
	private List list;
	
	
	public AutoBoxingDemo() {
		init();  
	}
	
	
	private void init() {
		list = new ArrayList(); 
	}
	
	public void demo() {
		
		// populate list with Integers 
		for(int i = 1 ; i <= 32 ; ++i ) {
			list.add(i * i);  // not explicitly creating Integer instances 
		}
		
		System.out.println("Size of List instance: " + list.size());

		Object firstItem =  list.get(0);
		
		// Let's demonstrate that it's stored as an instance of Integer wrapper Class ... 
		System.out.println("Class type: " + firstItem.getClass().getName());
		
		System.out.println("Object Instance Value: " + firstItem); 
			// What method are we implicitly calling here ?? - and whose method implementation are we 
		
		// We can choose to explicitly cast to an Integer - so we can use it as one ... 

		Integer i =  (Integer) list.get(0);
		System.out.println("Integer Instance Value: " + firstItem); 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AutoBoxingDemo theDemo = new AutoBoxingDemo(); 
		
		theDemo.demo(); 

	}

}
