package edu.cuny.csi.csc330.examples;

/**
 * JDK1.5 introduced "autoboxing"  and "generics"  
 * Autoboxing and unboxing, and generics lets developers write cleaner code, making it easier to read.
 * 
 *  *generics - "type" the elements contained in a given collection 
 *  *autoboxing - avoid the heavy lifting around converting primitive types to Wrapper Classses 
 *  
 *  BOTH OF THESE FEATURES ARE COMPILER "TRICKS" - the definition of the Java Lanaguage was unchanged ... 
 *      - similar to what allows String "conveniences" 
 *        String s1 = "value 1"; 
 *        String s2 = s1 + "2"; 
 * 
 *  * A For Each Loop was also added (JDK 1.5?)  - another compiler trick 
 * 
 */


import java.util.*;


public class AutoBoxingPlusDemo {
	
	private List<Integer> list;
	
	
	public AutoBoxingPlusDemo() {
		init();  
	}
	
	
	private void init() {
		list = new ArrayList<Integer>(); 
	}
	
	public void demo() {
		
		// populate list with Integers 
		for(int i = 1 ; i <= 32 ; ++i ) {
			list.add(i * i); 
		}
		
		
		System.out.println("Size of List instance: " + list.size());
		
		int sum = 0;
		for(Integer i : list) {  // should be read as, "for each i in list"
			sum = sum + i;
		    System.out.println(i);
		}
		System.out.println("Sum: " + sum + "\n");
		
		
		// BTW, also works over arrays 
		String[] languages = {"Java", "Scala", "C++", "Ruby", "Python", "Perl"};
        // looping over array using foreach loop
        for(String str : languages){
            System.out.println(str);
        }

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AutoBoxingPlusDemo starter = new AutoBoxingPlusDemo(); 
		
		starter.demo(); 

	}

}
