package edu.cuny.csi.csc330.ccvalidation;

public class DiscoverValidator extends BaseValidator implements Validator {


	/*
	 *  16 digits ... 
	 */
	
	protected Boolean isValidSpecific() {
		return Boolean.TRUE;
	}
	
	public Integer getAccountNumberLength() {
		return Integer.valueOf(16);
	}
	
}
