/**
 * This is an example of an "application defined, custom" Exception 
 * 
 * It extends the Base Core Java Exception and adds a numeric error code to the structure of the 
 * Exception.   So now, a thrown QuickPickerException can include an error code as well as a message 
 * to be logged ... 
 * The error code serves 2 purposes:
 * 1) provides a numeric code that can be "switched" through programmatically 
 * 2) index into an Exception message array 
 */
package edu.cuny.csi.csc330.newradio;


import java.util.* ;

public class RadioException extends Exception {
	
	// edu.cuny.csi.csc330.fall14.newradio
	
	  // static publicly defined error codes 
	  public static int	UNSET = 0; 
	  public static int	INVALID_STATE_CHANGE = 1; 
	  public static int INVALID_OPERATION = 2; 
	  public static int	INVALID_RANGE = 3; 
	    
	  // static publicly defined exception messages  
	  public static String[]  MESSAGE = { 
	  		"Code Unspecified", 
	  		"Invalid Radio State Change", 
	  		"Invalid Operation", 
	  		"Invalid Parameter Range"
	  } ;
	
		protected int code;  // have this exception carry a code as well as 
		
		// Constructors ... 
	    private  RadioException() { ; } 
	    
	    // with thrower  message 
	    public RadioException(String m) { 
	    	super(m); 
	    } 
	    
	    // with thrower message and code 
	    public RadioException(String message, int code) { 
	    	super(message);
	    	this.code = code;
	    } 
	    
		public int getCode() { 
			return code;
		}
		

	    @Override
		public String toString() {
			return "QuickPickerException [code=" + code + ", toString()="
					+ super.toString() + "]\n" + MESSAGE[code] ;
		}
	    
	    
		public static void main(String [] args ) {
			// test w/o code 
	    	RadioException re = new RadioException("Radio Exception Message ... ");
			System.out.println("Ex: " + re);
			
			// test with code 
			re = new RadioException("Radio Exception Message ... ", RadioException.INVALID_OPERATION);
			System.out.println("Ex: " + re);

	    }

}

