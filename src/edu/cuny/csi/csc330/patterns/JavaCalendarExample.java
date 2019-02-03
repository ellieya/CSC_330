/**
 * JavaCalendarExample demonstrates the usefulness of:
	 * Calendar 
	 * SimpleDateFormat 
	 * Date  

 * 
 * and highlights the fact that there are examples of Design Patterns in the Core Java lib itself!
 */
package edu.cuny.csi.csc330.patterns;

import java.util.*;
import java.text.*;

public class JavaCalendarExample {

	public JavaCalendarExample() {
		// TODO Auto-generated constructor stub
	}
	
	private static void display(Calendar calendar) {
		System.out.println("\nSimple Display"); 
		System.out.println( calendar.get(Calendar.MONTH) + "/" + 
				calendar.get(Calendar.DAY_OF_MONTH) + "/" +
				calendar.get(Calendar.YEAR)); 
	}
	
	private static void displayBetter(Calendar calendar) {
		System.out.println("\nBetter Display"); 
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formatter.format(calendar.getTime() ) );  

	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Locale locale = Locale.getDefault() ;
		System.out.println(locale); 

		Calendar calendar = Calendar.getInstance(locale); 
		
		/**
		 * THIS IS HOW Calendar.getInstance() IS IMPLEMENTED.
		 *     
		 *      public static Calendar getInstance(Locale aLocale)
	    		{
			        Calendar cal = createCalendar(TimeZone.getDefaultRef(), aLocale);
			        cal.sharedZone = true;
			        return cal;
	    		}
		 */
		
		calendar.setTime(new Date() );
		
		display(calendar); 
		
		calendar.add(Calendar.MONTH, 3);
		
		display(calendar); 
		
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		
		display(calendar); 
		
		displayBetter(calendar); 

	}

}
