/**
 * Demos implementations of the most common Collection Interfaces:  List, Map, Set
 */

package edu.cuny.csi.csc330.examples;

import java.util.*;


public class CollectionsStarter {
	
	private static final int INITIAL_COLLECTION_SIZE = 25; 
	private static final int INITIAL_MAP_SIZE = 89; 
	
	private List list ;
	private Map map ;
	private Set set ;

	public CollectionsStarter() {
		init();  
	}
	
	
	private void init() {
		
		list = new ArrayList(INITIAL_COLLECTION_SIZE); 
		map = new HashMap(INITIAL_MAP_SIZE); 
		set = new HashSet(INITIAL_COLLECTION_SIZE);
	}
	
	public void demo() {
		
		// populate list with Integers 
		for(int i = 1 ; i <= INITIAL_COLLECTION_SIZE * 2 ; ++i ) {
			list.add(new Integer(i * 100)); 
		}
		System.out.println("Size of List instance: " + list.size()); 
		
		// populate the map 
		Student student1 = new Student("Artie", "Kennedy"); 
		Student student2 = new Student("George", "Alexander"); 
		
		map.put(student1.getLastName(), student1); 
		map.put(student2.getLastName(), student2); 
		System.out.println("Size of Map instance: " + map.keySet().size()); 
		
		// populate the set 
		set.add("one"); 
		set.add("two"); 
		set.add("three"); 
		set.add("one"); 
		set.add("two");
		
		//  HOW MANY ELEMENTS DO WE EXPECT TO BE IN THIS Set INSTANCE?   WHY?  
		System.out.println("Size of Set instance: " + set.size()); 
		
		if( set.contains("two") ) {
			System.out.println("Found it!"); 
		}
		else {
			System.err.println("Not found ;-("); 
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CollectionsStarter starter = new CollectionsStarter(); 
		
		starter.demo(); 

	}

}
