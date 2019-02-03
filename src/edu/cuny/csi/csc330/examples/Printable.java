/** 
 *  Just as Classes can extend existing Classes, Interfaces can extend existing Interfaces 
 *  
 *  In this case, were defining Printable as a more "specialized" behavior than Displayable 
 */

package edu.cuny.csi.csc330.examples;

public interface Printable extends Displayable  {
	
	public static final String DEFAULT_PRINTER = "/dev/thePrinter"; 
	
	public String getPreferredPrinterDevice();

}
