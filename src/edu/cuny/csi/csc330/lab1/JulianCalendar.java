package edu.cuny.csi.csc330.lab1;

/**
 * Generates a non-leap year perpetual Julian Calendar 
 * @author lji
 *
 */
public class JulianCalendar {
	
	// Max number of Days in a month 
	static private  final int MAX_DAY = 31; 
	
	// abbreviated Month names 
	static private  final String [] MONTH_NAMES = {
		"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	};
	
	// day length of each month 
	static private final  int [] MONTH_SIZES = {
		31, 28, 31,30,31, 30, 31, 31, 30, 31, 30, 31
	};

	/**
	 * display The "DAY" Column Heading 
	 */
	static private void displayDayHeading() {
		System.out.printf("%5s", "Day");
		
	}
	
	/**
	 * display Month names between Day .... Day
	 */
	static private void displayHeading() {
		displayDayHeading(); 
		
		for(int i = 0 ; i < MONTH_NAMES.length ; ++i )  {
			System.out.printf("%5s", MONTH_NAMES[i]);
		}
		
		displayDayHeading(); 
	}
	

	static public void display() {
		displayHeading(); // display heading 
		
		/**
		 * Complete the logic to display a Julian cal given the pre-populated arrays defined by the Class
		 * 
		 * 
		 * 
		 * 
		 */
		
		int CUMULATIVE_DAY;
		int z = 2 < 1 ? 100:99;
		
		for (int i = 1; i <= MAX_DAY; ++i) {
			
			System.out.printf("%n  %03d ", i);
			
			CUMULATIVE_DAY = 1;
			
			for (int j = 0; j < MONTH_SIZES.length; CUMULATIVE_DAY += MONTH_SIZES[j], j++) { //Line reduced by 1 by moving line up here to execute with j++ because what this really is is an execution at the end
				
				//If FEBRUARY or months with 30 days, avoid printing day #'s
				if ((i > 28 && MONTH_SIZES[j] == 28) || (i > 30 && MONTH_SIZES[j] == 30)) {
					System.out.printf(" %3s ", '-');
				} else {
					System.out.printf(" %03d ", CUMULATIVE_DAY + i-1);
				}
			}
			
			System.out.printf(" %03d ", i);
		}

		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// invoke display method 
		display(); 
	}
}