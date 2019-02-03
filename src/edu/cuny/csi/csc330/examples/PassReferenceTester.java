package edu.cuny.csi.csc330.examples;

import java.util.Date;

public class PassReferenceTester {

		protected static void updateDate(Date  now) {
			//now = new Date();
			now.setYear(57); 
			System.out.println("The new value is " + now + ".");
		} 
		
		public static void main(String[] args) {
			Date now = new Date();
			System.out.println("Before updateDate(), now is " + now + ".");
			updateDate(now);
			System.out.println("After updateDate(), now is " + now + ".");
			
		}

}
