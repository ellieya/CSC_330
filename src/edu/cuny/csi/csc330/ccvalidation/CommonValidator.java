package edu.cuny.csi.csc330.ccvalidation;

public class CommonValidator extends BaseValidator implements Validator {
	
	public CommonValidator() {
		
	}
	
	public CommonValidator(String accountNumber) {
		setAccountNumber(accountNumber);
	}

	/**
	 * Implements the Luhn algorithm to validate ... 
	 */
	protected Boolean isValidSpecific() {

		if(getAccountNumber() == null ) {
			return Boolean.FALSE; 
		}
		
		// Call on LuhnChecker utility 
		String accountNumber = this.getAccountNumber();
		if(LuhnChecker.isValid(accountNumber) == true ) {
			//System.out.println(accountNumber + " passed validation");
			return Boolean.TRUE; 
		}
		else {
			//System.err.println(accountNumber + " ****falied validation****");
			return Boolean.FALSE;
		}
		
		//return Boolean.TRUE;
	}
	
	public Integer getAccountNumberLength() {
		return Integer.valueOf(16);
	}

}
