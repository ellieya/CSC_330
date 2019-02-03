package edu.cuny.csi.csc330.examples2;

import java.util.*;

import edu.cuny.csi.csc330.examples.Student;

public class SortedCollectionExample {

	public SortedCollectionExample() {
		// TODO Auto-generated constructor stub
	}
	
	private static void displaySet(Set set) {
		
		Iterator it = set.iterator();
		while(it.hasNext() ) { 
			System.out.println(it.next() ); 
		}
		System.out.println(""); 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> iSet = new TreeSet<Integer>();
		iSet.add(9); 
		iSet.add(1); 
		iSet.add(99); 
		iSet.add(77); 
		iSet.add(9190000); 
		iSet.add(8818); 
		iSet.add(77); 
		iSet.add(77); 
		iSet.add(8818); 
		
		SortedCollectionExample.displaySet(iSet); 
		
		Student student1 = new Student("733010", "Porter", "David", "CS", 3.1 );
		Student student2 = new Student("701010", "Quinn", "Bob", "CS", 3.9 );
		Student student3 = new Student("838383", "Metzger", "Bill", "CS", 3.65 );
		Student student4 = new Student("901100", "Adams", "Tom", "CS", 3.3 );
		
		Set<Student> sSet = new TreeSet<Student>();
		sSet.add(student1);
		sSet.add(student2);
		sSet.add(student3);
		sSet.add(student4);
		
		SortedCollectionExample.displaySet(sSet); 
		

	}

}
