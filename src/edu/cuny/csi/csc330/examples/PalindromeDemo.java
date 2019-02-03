package edu.cuny.csi.csc330.examples;

public class PalindromeDemo {
	
	private static boolean isPalindrome(String phrase ) {
		boolean rc = true; 
		
		char [] array = phrase.toCharArray(); 
		
		int start = 0, end = array.length - 1;
		
		while( start < end ) {
			if(array[start] != array[end])  {
				rc = false;
				break; 
			}
			++start;
			--end;  
			
		}
		
		return rc;  
	}

	public static void main(String[] args) {
		String  phrase = "yxy";
		if(args.length == 1 )  
			phrase = args[0]; 
		
		System.out.println(phrase +  ": " + isPalindrome(phrase));

	}

}
