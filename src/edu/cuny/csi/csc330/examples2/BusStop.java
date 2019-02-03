package edu.cuny.csi.csc330.examples2;

import java.util.*;

public class BusStop {
	
	private LinkedList<String> busStopQueue; 
	private int peopleIndex; 
	private static String [] people = {"Paul", "John", "George", "Herman", "Tina", "Mia", "Lisa", "Mal", 
		"Neil", "Lou", "Linda", "Brian", "Cynthia", "Maureen", "Patty", "Jane", "James"};

	public BusStop() {
		init(); 
	}
	
	private void init() {
		busStopQueue = new LinkedList<String>(); 
		
		// Add people - to BusStop 
		for(int i = 0 ; i < people.length ; ++i ) {
			busStopQueue.add(people[i]); 
		}
		
	}
	
	
	public void display(String comment) {
		
		System.out.printf("%s   Bus Stop People Count: %d\n",  comment, busStopQueue.size());
		System.out.println(busStopQueue);
		System.out.println("");
		
	}
	
	public void busArrives(int emptySeatCount) { 
		for(int i = 0 ; i < emptySeatCount ; ++i ) {
			String person = busStopQueue.poll(); 
			// 
		}
	}
	
	public void peopleArrive(int peopleCount) { 
		
		for(int i = 0 ; i < peopleCount ; ++i ) {
			if(this.peopleIndex == people.length ) 
				peopleIndex = 0; 
			
			busStopQueue.add(people[peopleIndex++]); 
			// 
		}
		
	}
	
	
	public void simulate() {
		
		display("Initial Bus Stop State");
		
		busArrives(11);  // 11 empty seats 
		display("After 1st Bus Stops");
		
		busArrives(2);  // another bus - 2 empty seats 
		display("After 2nd Bus Stops");
		
		peopleArrive(4);  // 4 new people arrive   
		display("After 4 people arrive");
		
		peopleArrive(2);  // 2 new people arrive   
		display("After 2 people arrive");
		
		busArrives(9);  // another bus - 9 empty seats 
		display("After 3rd Bus Stops");
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BusStop busStop = new BusStop(); 
		
		busStop.simulate(); 

	}

}
