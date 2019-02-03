package edu.cuny.csi.csc330.jdbc;

import java.util.*;
import java.io.*;

public class Student implements  Serializable {
	
	private int id;
	private double gpa;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String major;
	private Date dob;
	// derived property - age 
	


	public int getId() {
		return id;
	}


	public void setId(int iD) {
		id = iD;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gPA) {
		gpa = gPA;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Integer getAge() {
		
		Calendar dob = Calendar.getInstance();  
		dob.setTime(this.dob);  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
		// if birthday hasn't arrived yet 
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
			
		  age--;  
		} 
		else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
		    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
			
			age--;  
		}
		
		return age;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
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
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (id != other.id)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Student [ID=" + id + ", gpa=" + String.format("%4.2f", gpa) + ", firstName="
				+ firstName + ", emailAddress=" + emailAddress + ", lastName="
				+ lastName + ", major=" + major + ", dob=" + dob + "]";
	}


	public Student() {
		init(); 
	}
	
	
	
	/**
	 * @param gPA
	 * @param firstName
	 * @param emailAddress
	 * @param lastName
	 * @param major
	 * @param dob
	 */
	public Student(double gPA, String firstName, 
							String lastName, String emailAddress,
									String major, Date dob) {
		
		super();
		
		gpa = gPA;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.major = major;
		this.dob = dob;
	}


	/**
	 * @param iD
	 * @param gPA
	 * @param firstName
	 * @param emailAddress
	 * @param lastName
	 * @param major
	 * @param dob
	 */
	public Student(int iD, double gPA, String firstName, String emailAddress,
			String lastName, String major, Date dob) {
		super();
		id = iD;
		gpa = gPA;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.lastName = lastName;
		this.major = major;
		this.dob = dob;
	}


	private void init() {
	 
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student student = new Student( );
		System.out.println(student);

		
	
		

	}

}
