package edu.cuny.csi.csc330.fileio;

import java.util.*;
import java.io.*;

public class Person extends Object implements Serializable  {
	 
    private static final long serialVersionUID = 1234567890L;
    
    private static String DEFAULT_DELIMITER = ",";
    
	private Integer id; 
    private String firstName; 
    private String lastName; 
    private Date dob;
    private String emailAddress;
    private String cellNumber; 
    
 
    public Person() {
        // System.out.println("Inside the " + getClass().getName() + " constructor.");
    }
     
     
   
    @Override
	public String toString() {
		return this.getClass().getName() +  "\n[id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", emailAddress="
				+ emailAddress + ", cellNumber=" + cellNumber + "]";
	}
    
    /**
     * Generates a CSV Record from "instance state values"  
     * @return
     */
    public String toCSVString() {
    	return toCSVString(DEFAULT_DELIMITER); 
    }
    
	public String toCSVString(String delimiter) {
		return  id + delimiter + 
				firstName +  delimiter +
				lastName +  delimiter + 
				emailAddress +  delimiter + 
				cellNumber + "\n";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getCellNumber() {
		return cellNumber;
	}


	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cellNumber == null) ? 0 : cellNumber.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (cellNumber == null) {
			if (other.cellNumber != null)
				return false;
		} else if (!cellNumber.equals(other.cellNumber))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}




}