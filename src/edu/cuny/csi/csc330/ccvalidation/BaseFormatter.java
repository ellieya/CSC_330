package edu.cuny.csi.csc330.ccvalidation;

import java.util.*;
import java.io.*;
import java.text.*;


// offers some CC account number manipulation methods ... 
public abstract class BaseFormatter {
	
	private String accountNumber; 
	private int grouping[] = null; 
	
	
	public BaseFormatter() {
		
	}
	

	protected String plainReverse() {
		
		return null; 
	}
	

	protected String reverseString(String string){
		char [] carray = string.toCharArray();
		int length = string.length(); 
		StringBuffer rbuffer = new StringBuffer(length);
		
		for (int i = length ; i > 0  ; --i ) {
			rbuffer.append(carray[i-1]);
		}

		return rbuffer.toString();
		
	}
	
	protected int [] stringToIntArray( String from ) {
		//->>>>> BREAK OUT TO A STATIC UTIL METHOD 
		char [] reverseCValues = from.toCharArray();
		int [] reverseIValues = new int[reverseCValues.length];  
		
		for(int i = 0 ; i < reverseCValues.length ; ++i ) {
			switch(reverseCValues[i]) {
			case '0':
				reverseIValues[i] = 0;
				break; 
			case '1':
				reverseIValues[i] = 1;
				break; 
			case '2':
				reverseIValues[i] = 2;
				break; 
			case '3':
				reverseIValues[i] = 3;
				break; 
			case '4':
				reverseIValues[i] = 4;
				break; 
			case '5':
				reverseIValues[i] = 5;
				break; 
			case '6':
				reverseIValues[i] = 6;
				break; 
			case '7':
				reverseIValues[i] = 7;
				break; 
			case '8':
				reverseIValues[i] = 8;
				break; 
			case '9':
				reverseIValues[i] = 9;
				break;
			default:
				break;
			}
		}
		
		return reverseIValues; 
	}

	protected String spaceString(String string){
		final String delimiter = " ";
		final int repeat = 1; 
		
		
		return spaceString(string, delimiter, repeat);
		
	}
	
	protected String spaceString(String string, String delimiter, int padSize){
		char [] carray = string.toCharArray();
		int length = string.length(); 
		StringBuffer rbuffer = new StringBuffer(length * 3);
		
		for (int i = 0 ; i < length  ; ++i ) {
			rbuffer.append(carray[i] );
			for (int j = 0 ; j < padSize  ; ++j ) {
				rbuffer.append(delimiter );
			}
		}
	
		return rbuffer.toString();
		
	}

	
 
	/*
	 * Base attribute getter/setter bean methods 
	 */
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int[] getGrouping() {
		return grouping;
	}


	public void setGrouping(int[] grouping) {
		this.grouping = grouping;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + Arrays.hashCode(grouping);
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
		final BaseFormatter other = (BaseFormatter) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (!Arrays.equals(grouping, other.grouping))
			return false;
		return true;
	}
	
	
	
}
