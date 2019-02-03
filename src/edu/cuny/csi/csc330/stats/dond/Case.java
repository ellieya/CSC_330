/**
 * 
 * Case 
 * 
 * This Class models the "Case" entity on the "Deal or No Deal" game. 
 * It's structure includes:
 * - index number: that is, case 1:26 
 * - a monetary value 
 * - boolean opened/closed state  
 * 
 */


// package line 
package edu.cuny.csi.csc330.stats.dond;

//Class Declaration  
public class Case {
	
	private int number;  
	private double value; 
	private boolean opened; 

	public double getValue() {
		return value;
	}
	
	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		String state = String.format(" Case: %2d  Value: $%,.2f", number, value); 
		return state; 
		
		/*return "Case [number=" + number + ", value=" + value + ", opened="
				+ opened + "]";*/ 
	}

	public Case(int number, double value) {
		this.number = number;
		this.value = value;
		opened = false; 
	}

}
