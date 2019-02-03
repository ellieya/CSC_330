package edu.cuny.csi.csc330.examples2;

import java.util.*;

public class DriveWay {
	
	private Stack<String> carStack; 

	public DriveWay() {
		init(); 
	}
	
	private void init() {
		carStack = new Stack<String>(); 
		
		// push initial Family cars in drive way 
		carStack.push("FAM-001"); 
		carStack.push("FAM-002"); 
		carStack.push("FAM-003"); 
		
	}
	
	
	public void display(String comment) {
		
		System.out.printf("%s  Car Count: %d\n",  comment, carStack.size());
		System.out.println(carStack);
		System.out.println("");
		
	}
	
	public void arrive(String plate) { 
		carStack.push(plate);
	}
	
	public void depart(String plate) { 
		
		// last one parked 
		if(plate.equals( carStack.peek()) ) {
			carStack.pop(); 
			return; 
		}
		
		// let's examine the stack 
		int position = carStack.search(plate); 
		
		if(position < 1 ) { // not in driveway 
			System.err.println(plate + " not in driveway");
			return;
		}
		
		// must be some in the driveway 
		Stack<String> tempStack = new Stack<String>(); 
		 
		for(int i = 0 ; i < (position-1) ; ++i) {
			tempStack.push( carStack.pop() ) ; 
		}
		
		
		if(carStack.empty() == false) 
			carStack.pop(); 
		
		while(tempStack.empty() == false) {
			carStack.push( tempStack.pop() );
		}
		
	}
	
	
	public void simulate() {
		
		display("Initial DriveWay State");
		
		// Guest1 arrives 
		arrive("GST-001");
		
		// Guest2 arrives 
		arrive("GST-002");
		
		// Guest3 arrives 
		arrive("GST-003");
		display("After 3 Guests Arrive"); 
	
		
		// 1st departure 
		depart("GST-003");
		display("After 1st Departure");
		
		
		// Fam Car 2 needs to leave 
		depart("FAM-002");
		display("After 2nd Departure: " + "FAM-002");
		
		// 1st car parked needs to leave
		depart("FAM-001");
		display("First car parked Departure: " + "FAM-001");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DriveWay driveway = new DriveWay(); 
		
		driveway.simulate(); 

	}

}
