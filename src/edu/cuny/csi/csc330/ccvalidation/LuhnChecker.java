package edu.cuny.csi.csc330.ccvalidation;

import java.util.*;


public class LuhnChecker {
	
	
	static {
		
	}
	
	static boolean isValid(String accountNumber) {
		return isValid( accountNumber, false); 
	}
	
	static boolean isValid(String accountNumber, boolean verbose) {
		
		/*
		 * Create simple formatter, follow ccval.sh scripts - and column 
		 * instructions ... 
		 */
		CommonFormatter formatter = new CommonFormatter();
		/*
		 * Example output from shell script 
		 * $ ./ccvalidate  4482750102585113
				4 4 8 2 7 5 0 1 0 2 5 8 5 1 1 3
				3 1 1 5 8 5 2 0 1 0 5 7 2 8 4 4
				3 2 1 1 8 1 2 0 1 0 5 5 2 7 4 8
				50
				4482750102585113 IS A VALID credit card
				
				$ ./ccvalidate  4482750102585115
				4 4 8 2 7 5 0 1 0 2 5 8 5 1 1 5
				5 1 1 5 8 5 2 0 1 0 5 7 2 8 4 4
				5 2 1 1 8 1 2 0 1 0 5 5 2 7 4 8
				52
				4482750102585115 IS NOT A VALID credit card
		 */
		
		/** Algorithm: 
		 * -form an array of summable values from acct chars would be fine 
		 * -reverse account # and form an array of summable values for that also
		 * -double every 2nd number in reversed array, and if value > 9, subtract 9
		 * -now add up the value of each element in that array .... 
		 * - if that sum % 10 == 0, then number is valid 
		 */
		
		String reverseNumber = formatter.reverseString(accountNumber);
		int []reverseIValues = formatter.stringToIntArray(reverseNumber);
		
		int sum = 0; 
		for(int i = 0 ; i < reverseIValues.length ; ++i ) {
			if(i%2 == 1 ) {
				reverseIValues[i] = reverseIValues[i] * 2;
				if(reverseIValues[i] > 9 ) 
					reverseIValues[i] = reverseIValues[i] - 9;
				
			}
				
			sum = sum + reverseIValues[i]; 
			
			if(verbose) {
					System.out.println(" char[" + i + "] " + reverseIValues[i]); 
			}
			
		}
		
		if(sum % 10 == 0) 
			return true;
	
		return false; 
	}

	

}
