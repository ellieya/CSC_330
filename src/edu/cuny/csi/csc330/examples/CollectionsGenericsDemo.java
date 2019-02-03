/**
 * Demonstrates Lists and Maps using generics 
 */
package edu.cuny.csi.csc330.examples;

import java.util.*;

public class CollectionsGenericsDemo {

	public CollectionsGenericsDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Person> phoneBook = new HashMap<Integer,Person>(113);
		
		Person person = new Person(10010, "Joe", "Butler"); 
		person.setCellPhone("917.555.2234");
		person.setCellPhone("201.555.5938");
		
		phoneBook.put(person.getID(), person);
		
		Person foundPerson = phoneBook.get(person.getID());
				
		System.out.println("Person Found by ID in HashMap: " + foundPerson + "\n" );
				
		
		List<String> phoneNumbers = new ArrayList<String>(10);
		
		// phoneNumbers.add(1); 
		phoneNumbers.add("917.555.2234"); 
		phoneNumbers.add("937.555.4234"); 
		phoneNumbers.add("927.455.2534"); 
		phoneNumbers.add("927.545.4234"); 
		 
		System.out.println("Phone Numbers List Size: " + phoneNumbers.size() ); 
	}

}
