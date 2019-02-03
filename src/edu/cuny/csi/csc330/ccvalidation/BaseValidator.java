package edu.cuny.csi.csc330.ccvalidation;

public abstract class BaseValidator implements Validator {
	
	private String accountNumber; 
	
	
	public BaseValidator() {
		init(); 
	}
	
	private void init() {
		/*
		 */
		
	}
	
	private final Boolean isValidLength() {
		
		// if length NA, ignore ... 
		if(getAccountNumberLength() == null || 
				getAccountNumberLength().intValue() == 0 ) 
			return Boolean.TRUE; 
		
		// check length 
		if(this.accountNumber.length() != this.getAccountNumberLength().intValue() )
			return Boolean.FALSE; 
		

		return Boolean.TRUE; 
	}

	public final Boolean isValid() {
		
		// If length is ok, then proceed with other checks
		if(isValidLength() == true ) {
			
			
			
			// concrete class will have implemented this 
			return isValidSpecific();
			
		}
		
		return Boolean.FALSE;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public abstract Integer getAccountNumberLength() ;

	protected abstract Boolean isValidSpecific() ;


}
