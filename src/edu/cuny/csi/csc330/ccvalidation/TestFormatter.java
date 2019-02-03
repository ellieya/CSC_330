package edu.cuny.csi.csc330.ccvalidation;

public class TestFormatter extends BaseFormatter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestFormatter formatter = new TestFormatter();
		
		String r = formatter.reverseString(args[0]); 
		System.out.println(r); 
		
		String s = formatter.spaceString(args[0]); 
		System.out.println(s); 


		System.exit(0); 

	}

}
