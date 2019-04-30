/**
 * Class that represents a Street Corner 
 * Instances of this Class will be used to track the history 
 * and current location of DrunkWalker(s)
 */
package edu.cuny.csi.csc330.lab5;

import java.util.Set;
import java.util.TreeSet;


public class Intersection implements Comparable<Intersection>  {
	
	private int avenue;
	private int street; 

	public Intersection() {
		
	}
	// !!!!!!!!!!!!!!!!!  
	/**
	 * Constructor that takes ave and street values as parameters ... 
	 */
	
	
	/**
	 * toString() method  !!!!!!!!!!!!!!!!!
	 */
	
	
	
	/**
	 * Getters/Setters !!!!!!!!!!!!!!!!!!!
	 */
	
	

	/**
	 * hashCode() and equals() methods 
	 */
	
	@Override
	public int compareTo(Intersection corner) {
		if(this.avenue == corner.avenue)
			return new Integer(this.street).compareTo(corner.street);
		
		return new Integer(this.avenue).compareTo(corner.avenue);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Implement a Testing main()   !!!!!!!!!!!!!!!!
		
		// Complete the methods implied through comments above 
		// Then uncomment the test code below, and run. 
		
		/*
		Intersection corner1 = new Intersection(6, 23); 
		Intersection corner2 = new Intersection(7, 41); 
		Intersection corner3 = new Intersection(1, 3); 
		Intersection corner4 = new Intersection(3, 4); 
		Intersection corner5 = new Intersection(7, 34); 
		
		System.out.println("Corner 1: " + corner1); 
		System.out.println("Corner 2: " + corner2); 
		
		if(corner1.equals(corner2 ) == false ) 
				System.out.println("Corners are not equal."); 
		
		
		// Test Sorting ... for lab5 req 
		Set<Intersection> set = new TreeSet<Intersection>(); 
		set.add(corner1);
		set.add(corner2);
		set.add(corner3);
		set.add(corner4);
		set.add(corner5);
		
		System.out.println(set);
		
		System.exit(0);
		 
		 */

	}

}