package edu.cuny.csi.csc330.ccvalidation;

public class MasterValidator  extends BaseValidator implements Validator {
	
	public Integer getAccountNumberLength() {
		return Integer.valueOf(16);
	}
	
	protected Boolean isValidSpecific() {
		return Boolean.TRUE;
	}

}
