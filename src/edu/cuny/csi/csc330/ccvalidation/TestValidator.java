package edu.cuny.csi.csc330.ccvalidation;


/**
 * 
 * @author lji
 *
 */
// public class TestValidator extends AmexValidator implements Validator {
public class TestValidator extends BaseValidator implements Validator {

	public TestValidator(String s) {
		
	}
	
	public Integer getAccountNumberLength() {
		return Integer.valueOf(16);
	}
	
	protected Boolean isValidSpecific() {
		return Boolean.TRUE;
	}
	
}
