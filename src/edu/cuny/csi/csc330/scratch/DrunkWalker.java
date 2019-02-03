package edu.cuny.csi.csc330.scratch;

import java.math.*;
import java.util.*;


public class DrunkWalker {
	
	private Intersection startIntersection;
	private Intersection currentIntersection;
	private int avenue;
	private int street;
	private Map<Intersection, Integer> visits;

	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  
	// add other data members here including Collection instances that you will use to 
	// to track history and statistics ... 

	private DrunkWalker() {
		init();
	}
	
	/**
	 * 
	 * @param avenue
	 * @param street
	 */
	public DrunkWalker(int avenue, int street) {	
		init();
		this.avenue = avenue;
		this.street = street;
		startIntersection = new Intersection(avenue, street);
	}
	
	private void init() {
		// What should be do here to initialize an instance?? 
		visits = new HashMap<Intersection,Integer>(1000);
	}
	
	/**
	 * step in a random direction 
	 */
	public void step() {
		
		takeAStep(); 
		currentIntersection = new Intersection(avenue, street);
		
		if(!visits.containsKey(currentIntersection)) {
			visits.put(currentIntersection, 1);
		}
		else {
			visits.put(currentIntersection, visits.get(currentIntersection)+1);
		}
		
		/**  !!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * Now, update the Collections that manage the following:
		 * 
		 *  1) add this next step/intersection to a "history" List that will contain the sequence of all 
		 *  steps taken by this DrunkWalker instance 
		 *  
		 *  2) add this next step to a Intersection -> Counter Map ... The Map 
		 *  Collection can and should be of Generics "Type" <Intersection, Integer> 
		 *  key = Intersection 
		 *  value = Count Value  
		 *  Need to do something like this: 
		 *  if intersection is not saved in Map yet as a key yet, add a key->value pair of Intersection->1 
		 *  else if intersection value is there, the existing key->value pair need to be replaced as 
		 *   Intersection->existing_count+1 
		 *   
		 */
	}
	
	
	private void takeAStep() {
		Direction dir = Direction.NONE.getNextRandom(); 
		
		/** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * now what do we do based on the random Direction created? 
		 * How do we go about updating the "currentIntersection" instance to reflect the 
		 * direction/step that was just selected? 
		 */
		
		switch (dir) {
		case NORTH:
			street++;
		case EAST:
			avenue--;
		case SOUTH:
			street--;
		case WEST:
			avenue++;
		case NORTHEAST:
			avenue--;
			street++;
		case NORTHWEST:
			avenue--;
			street--;
		case SOUTHEAST:
			avenue++;
			street--;
		case SOUTHWEST:
			avenue++;
			street++;
		}		
	}


	/** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * toString() 
	 * @return
	 */
	@Override
	public String toString() {
		return "DrunkWalker [avenue=" + avenue + ", street=" + street + "]";
	}

	/**
	 * generate string that contains current intersection/location info 
	 */
	public String getLocation() {
		// !!!!!!!!!!!!!!!!!  
		return String.format("Current location: DrunkWalker [avenue=%d, street=%d]", 
				currentIntersection.getAvenue(), currentIntersection.getStreet() );
	}

	/**
	 * Take N number of steps 
	 * @param steps
	 */
	public void fastForward(int steps ) {
		// Considering that we already have a step() method, how would we 
		//  implement this method?  Uhh, think reuse! 
		for(int i = 0; i < steps; i++) {
			step();
		}
	}
	
	/**
	 * Display information about this current walker instance 
	 */
	public void displayWalkDetails() {
		/**
		 * This method needs to display the following information in a neat, readable format 
		 * using calls to System.out.println() or System.out.printf()
		 * 
		 * 1 - starting location 
		 * 2 - current/ending location 
		 * 3 - distance (value returned by howFar() ) 
		 * 4 - number of steps taken - which collection would be able to provide that information, and how?  
		 * 5 - number of unique intersections visited - 
		 * 		which collection would be able to provide that information, and how? 
		 * 6 - Intersections visited more than once 
		 * 
		 */
		System.out.println("Starting location: " + startIntersection.getAvenue() + " avenue " + startIntersection.getStreet() + " street");
		System.out.println("Ending location: " + currentIntersection.getAvenue() + " avenue " + currentIntersection.getStreet() + " street");
		System.out.println("Distance Traveled: " + howFar());
		for(Map.Entry<Intersection, Integer> m : visits.entrySet()) {
			if(m.getValue() > 1)
			System.out.println("Intersection: " + m.getKey() + "\t Times Visited: " + m.getValue());
		}
		
		
	}
	
	/**
	 * X Y Coordinate distance formula 
	 *  |x1 - x2| + |y1 - y2|   
	 * @return
	 */
	public int howFar() {
		//|x1 - x2| + |y1 - y2|
		
		int x1 = startIntersection.getAvenue();
		int y1 = startIntersection.getStreet();
		int x2 = currentIntersection.getAvenue();
		int y2 = currentIntersection.getStreet();
	 
		return (Math.abs(x1 - x2) ) + (Math.abs(y1 - y2)); 
	}


	public static void main(String[] args) {
		
		// create Drunkard with initial position (ave,str)
		DrunkWalker billy = new DrunkWalker(6,23);
		for(int i = 1 ; i <= 3 ; ++i ) {
			billy.step(); 
			System.out.printf("Billy's location after %d steps: %s\n",
					i, billy.getLocation() );
		}
			
		
		// get his current location
		String location = billy.getLocation();
		// get distance from start
		int distance = billy.howFar();
		System.out.println("Current location after fastForward(): " + location);
		System.out.println("That's " + distance + " blocks from start.");
		

		// have him move 25  random intersections
		billy.fastForward(25);
		billy.displayWalkDetails();

	}

}
