/**
 * 
 */
package edu.cuny.csi.csc330.examples;

import java.util.*;

/**
 * @author Louis.Iacona
 *
 */
public class StudentSorter {

	protected static void displayStudents(Collection<Student> set) {
		
		for(Student student :  set ) {
			System.out.println(student); 
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Set<Student> students = new TreeSet<Student>(); 
		
		Set<Student> students = new HashSet<Student>(); 
		
		students.add(  new Student("100", "Lane", "Lois", "CS", (double) 3.33)   ); 
		students.add(  new Student("900", "Olsen", "Jimmy", "EDU", (double) 3.9)   ); 
		students.add(  new Student("700", "White", "Perry", "JNL", (double) 3.86)   );
		students.add(  new Student("600", "Kent", "Clark", "GEO", (double) 4.0)   );
		students.add(  new Student("500", "Smith", "Lois", "GEO", (double) 3.1)   );
		students.add(  new Student("150", "Kent", "John", "CS", (double) 3.0)   );
		
		List<Student> sortedList = new ArrayList<Student>(students); 
		Collections.sort(sortedList);
		
		displayStudents(sortedList); 

	}

}
