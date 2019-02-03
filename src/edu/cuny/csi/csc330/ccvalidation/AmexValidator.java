package edu.cuny.csi.csc330.ccvalidation;

public class AmexValidator extends BaseValidator implements Validator {

	/*
	 *  15 digits ... 
	 */
	
	protected Boolean isValidSpecific() {
		return Boolean.TRUE;
	}
	
	public Integer getAccountNumberLength() {
		return Integer.valueOf(15);
	}
	
}
