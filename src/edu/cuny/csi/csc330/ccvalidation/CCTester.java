package edu.cuny.csi.csc330.ccvalidation;

public class CCTester {

	public CCTester() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args == null || args.length == 0 ) {
			System.err.println(" Need a credit card number" ); 
			System.exit(1); 
		}
		
		String accountNumber = args[0]; 
		
		// Special Validator
		
		System.out.println("Account: " + accountNumber );
		
		Validator amex = 
				ValidationServices.newInstance("com.louisiacona.cc.AmexValidator");
		amex.setAccountNumber(accountNumber);
		System.out.println("Amex Val Class: " + amex.getClass().getName() );
		//System.out.println("  HashId: " + amex.hashCode() );
		System.out.println("Amex Val Results: " + amex.isValid()); 
	
		
		// Default Validator 
		Validator validator = ValidationServices.getInstance();
		validator.setAccountNumber(accountNumber);
		
		System.out.println("Common Val Class: " + validator.getClass().getName() );
		//System.out.println("  HashId: " + validator.hashCode() );
		System.out.println("Common Val Results: " + validator.isValid()); 
		
		System.exit(0);
	}

}
