package edu.cuny.csi.csc330.calc;
import java.math.*;

public class Calculator  {

	// Attributes (private) 
	
	// numeric value 
	private double currentValue; 
	// 1 + 8 + 9 
	private boolean power; 
	
	
	// Constructor 
	public Calculator() {
		init(); 
	}

	
	@Override
	public String toString() {
		return "Calculator [currentValue=" + currentValue + "]";
	}


	public double getCurrentValue() {
		return currentValue;
	}


	// public methods 
	public void clear(  ) {
		currentValue = 0; 
	}
	
	public void add( double param ) {
		if(isOn() == false ) return; 
		
		currentValue += param; 
		// currentValue = currentValue + param; 
	}
	
	public void subtract( double param ) {
		if(isOn() == false ) return; 
		
		currentValue -= param; 
		return; // optional return statement 
	}
	
	public void divide( double param ) throws DivideByZeroException {
		if(isOn() == false ) return; 
		
		if(param == 0) {
			throw new DivideByZeroException("Cannot Divide By Zero: " + param );
		}
		// int x = 10 / 0;
		currentValue /= param; 
		// currentValue = currentValue + param; 
	}
	
	public void negate(  ) {
		if(isOn() == false ) return; 
		
		currentValue = -1 * currentValue; 
		// currentValue = currentValue + param; 
	}
	
	
	public void multiply( double param ) {
		if(isOn() == false ) return;  
		
		currentValue *= param; 
		// currentValue = currentValue + param; 
	}
	
	public boolean isOn(  ) {
		return power; 
	}
	
	public void on(  ) {
		power = true; 
	}
	
	public void off(  ) {
		power = false; 
	}
	
	
	// private methods 
	private void init() {
		this.power = true; 
		this.currentValue = 0;
		
	}
	
	public static void main(String[] args) {
		
		// sample unit test 
		Calculator calculator = new Calculator(); // create new instance  
		
		calculator.add(512);
		
		try {
			calculator.divide(0);
		}
		catch(DivideByZeroException ex)  {
			System.err.println(ex);
		}
		
		
		
		System.out.println(calculator.getCurrentValue()); // peek at value 
	

		calculator.add(2); // perform math ops 
		calculator.add(2);
		System.out.println(calculator.getCurrentValue()); // peek at value 
		calculator.clear();     // clear 
		System.out.println(calculator.getCurrentValue()); // peek at value 
		
	} 

	
	
}
