package edu.cuny.csi.csc330.examples2;

import java.util.*;


public class AgeCalculator {

	public AgeCalculator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Calendar dob = Calendar.getInstance();  
		dob.setTime(new Date(57, 9, 5));  
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
		
		System.out.println(age);

	}

}
