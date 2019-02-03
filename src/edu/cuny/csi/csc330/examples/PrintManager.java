/**
 * PrintManaager is a "utility" Class that has a very specific capability ... 
 * It knows how to send the "Displayable" output to a Printer Device  
 * 
 */

package edu.cuny.csi.csc330.examples;

// This is considered a "singleton" class 
public class PrintManager {
	
	private static PrintManager theManager; 

	// don't allow creation of PrintManager through "traditional means" 
	private PrintManager() {
		 
	}
	
	public synchronized static PrintManager getManager() {
		if(theManager == null) {
			theManager = new PrintManager(); 
		}
		
		return theManager;
		
	}
	
	public void print(Printable printable ) {
		
		String printer = printable.getPreferredPrinterDevice(); 
		if( printer == null || printer.length() == 0)
			printer = printable.DEFAULT_PRINTER; 
		
		print(printable.getDisplayContent(), printer); 
	}
	
	private void print(String job, String printer ) {
		
		// PRETENDING TO PRINT 
		System.out.println("Simulating print to: "  + printer); 
		System.out.println(job); 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
