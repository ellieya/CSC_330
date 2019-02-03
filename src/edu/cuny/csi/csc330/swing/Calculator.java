package edu.cuny.csi.csc330.swing;

import java.lang.Math; // not required statement - compiler includes by default 

public class Calculator  {

	// Attributes (private) 
	private double currentValue; 
	
	// private methods 
	private void init() {
		clear();
	}
	
	
	// Constructor 
	public Calculator() {
		init(); 
	}

	///////////////////////////////////////////////////////
	// public methods 
	public void clear(  ) {
		currentValue = 0; 
	}
	
	@Override
	public String toString() {
		return "Calculator [currentValue=" + currentValue + "]";
	}


	// Getter ... 
	public double getCurrentValue() {
		return currentValue;
	}

	
	public void multiply( double param ) {
		currentValue *= param; 
	}
	
	public void percentage( double param ) {
		currentValue *= (param/100); 
	}
	
	public void add( double param ) {
		currentValue += param; 
		// currentValue = currentValue + param; 
	}
	
	public void subtract( double param ) {
		
		currentValue -= param; 
		return; // optional return statement 
	}
	
	public void divide( double param )  {
		if(param == 0) {
			// display error 
			return; 
		}
		currentValue /= param; 
	}
	
	public void negate(  ) {
		currentValue = -1 * currentValue; 
	}
	
	public void invert(  ) {
		currentValue = 1 / currentValue; 
	}
	
	public void squareRoot(  ) {
		currentValue = Math.sqrt(currentValue); 
	}
	
	public void square() {
		pow(2);
	}
	
	public void pow( double param) {
		currentValue = Math.pow(currentValue, param); 
	}
	
	// Trig operation
	public void tan( ) {
		currentValue = Math.tan(currentValue); 
	}
	
	public void cos( ) {
		currentValue = Math.cos(currentValue); 
	}
	
	public void sin( ) {
		currentValue = Math.sin(currentValue); 
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		if (Double.doubleToLongBits(currentValue) != Double
				.doubleToLongBits(other.currentValue))
			return false;
		return true;
	}


	public static void main(String[] args) {
		
		// sample unit test 
		Calculator calculator = new Calculator(); // create new instance  
		System.out.println(calculator.getCurrentValue()); // peek at value 
		
		calculator.add(7777);
		calculator.add(9);
		System.out.println(calculator.getCurrentValue()); // peek at value 
	
		calculator.square(); // perform math ops 
		System.out.println(calculator.getCurrentValue()); // peek at value 
		calculator.invert();   
		System.out.println(calculator.getCurrentValue()); // peek at value 
		
		calculator.invert();  
		calculator.percentage(10);  
		System.out.println(calculator.getCurrentValue()); // peek at value 
		
		calculator.clear();  
		System.out.println(calculator.getCurrentValue()); // peek at value 
		
	} 


}
