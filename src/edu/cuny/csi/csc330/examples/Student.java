package edu.cuny.csi.csc330.examples;

import java.util.*;
import java.io.*;

public class Student implements Comparable<Student>, Serializable {
	
	private String ID;
	private double GPA;
	private String firstName;
	private String lastName;
	private String major;
	private List<String> sessionList;
	private List<String> absentSessionList;

	public Student() {
		init(); 
	}
	
	public Student(String firstName, String lastName ) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		init(); 
	}
	
	
	public Student(String ID, String lastName, String firstName, String major, double GPA) {
		this.ID = ID;
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.GPA = GPA; 
		this.major = major; 
		init();
		
	}
	
	private void init() {
		sessionList = new ArrayList<String>(25);
		absentSessionList = new ArrayList<String>(25);
	}
	

	public int compareTo(Student student ) {
		// sort by last name 
		int rc = this.lastName.compareTo(student.lastName); 
		if(rc == 0 ) {
			return this.firstName.compareTo(student.firstName);
		}
		return rc; 
		
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", GPA=" + GPA + ", firstName="
				+ firstName + ", lastName=" + lastName + ", major=" + major
				+ "]";
	}
	
	// Other Public Methods ... 
	public void addAttendanceIndicator(String week, String ind) {
		
		this.sessionList.add(week); 
		
		if("Y".equalsIgnoreCase(ind) == false ) {
			this.absentSessionList.add(week); 
		}

	}
	
	public double getAbsenteeRate() {
		return ((double) this.absentSessionList.size() / this.sessionList.size() );
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student student = new Student("101010", "Bob", "Porter", "CS", 3.9 );
		System.out.println(student);
		
		student.addAttendanceIndicator("Week1", "Y");
		student.addAttendanceIndicator("Week2", "Y");
		student.addAttendanceIndicator("Week3", "Y");
		student.addAttendanceIndicator("Week4", "Y");
		student.addAttendanceIndicator("Week5", "Y");
		student.addAttendanceIndicator("Week6", "N");
		student.addAttendanceIndicator("Week7", "Y");
		student.addAttendanceIndicator("Week8", "Y");
		
		
		
		System.out.printf("Abs Rate: %.3f\n", student.getAbsenteeRate());
		

	}

}
