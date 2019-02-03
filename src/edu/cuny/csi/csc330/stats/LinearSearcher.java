/**
 * This class models the actions of a linear search over a fixed number (100) of unsorted integers  ... 
 * Expected performance = N/2 .. a match after about 50 tries 
 * 
 * Fixed values: 
 * - the number being searched for (I) 
 * - the size of the integer list 
 * 
 * Changing values: 
 * - the number of searches we perform 
 * - list is shuffled after each search is completed 
 * - the calculated average number of times required to find I 
 * 
 * Expected Behavior:
 * - The larger number of search events, the average performance will get closer to N/2 
 * 
 */
package edu.cuny.csi.csc330.stats;

import java.util.*;
import java.io.*;

public class LinearSearcher {
	
	protected static int SEARCHED_VALUE = 77; 
	protected static int LIST_SIZE = 100; 
	protected static List<Integer> list; 
	protected static List<Integer> foundIndicies; 
	
	static {
		list = new ArrayList<Integer>(LIST_SIZE);
		foundIndicies = new ArrayList<Integer>();
		
		// populate the lists 
		for(int i = 1 ; i <= LIST_SIZE ; i++ ) {
			list.add(i);
		}
		
	}


	static private double calculateFoundAverage() {
	    long sum = 0;
	    for (Integer num : foundIndicies) {
	        sum += num;
	    }
	    return  (1.0 * sum) / foundIndicies.size();
	}
	
	protected static void test(int testSeq, int searches) {
		
		foundIndicies.clear();

		// shuffle them up at the start of each search 
		for(int i = 0 ; i < searches ; i++ ) { 
			Collections.shuffle(list ); 
			
			int j; 
			for( j = 0; j < list.size() ; ++j)  {
				if(list.get(j).equals(SEARCHED_VALUE)) 
					break; 
			}
			
			foundIndicies.add(j+1);
		}
		
		double avg = calculateFoundAverage(); 
		
		// System.out.println(list);
		// Collections.sort(foundIndicies);
		// System.out.println(foundIndicies);
		
		System.out.printf("\nTEST %d\n", testSeq); 
		System.out.printf("\tAfter %,d searches, the saught after number (%d) was found on average after [[%.2f]] tries over %d elements\n\n",
				searches, SEARCHED_VALUE,  avg, list.size() ); 
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		/**
		 * i = number of linear searches
		 * j = Nth test set for "i" searches 
		 */
		for(int i = 10 ; i <= 1000000 ; i *= 10 ) {
			
			for(int j = 0 ; j < 4 ; ++j ) {
				test(j+1, i); 
			}
			
			System.out.print("Hit Enter to continue: ");
			String dummy = scanner.nextLine(); 
		}
		
		System.out.println("Exiting .. ");
		
	
	}

}
