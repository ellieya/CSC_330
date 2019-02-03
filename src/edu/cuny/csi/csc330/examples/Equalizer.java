/**
 * This Class demonstrates equals() vs == 
 * using instances of the Person Class ... 
 */

package edu.cuny.csi.csc330.examples;

public class Equalizer {

	public Equalizer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// reference1 == reference2, will equals() between those instances necessarily return true??
		Person person1 = new Person(100, "Beroni", "Sal");
		Person person2 = person1;
		
		Person person3 = new Person(101, "Smith", "Holly");
		Person person4 = new Person(101, "Johnson", "Bill");
		
		if(person1 == person2 ) {
			System.out.println(person1); 
			System.out.println(person2);
			System.out.println( person2.equals(person1) + "\n");
		}
		else {
			System.out.println("references are not pointing to the same object");
		}
		
		if(person3.equals(person4) == false) {
			System.out.println("As expected, p3 & p4 are not equal()");
		}
		else {
			System.err.println(" p3 & p4 are equal() - unexpected issue");
		}
		

	}

}
