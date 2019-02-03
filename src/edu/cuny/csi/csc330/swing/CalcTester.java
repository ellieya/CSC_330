package edu.cuny.csi.csc330.swing;

public class CalcTester {

	public CalcTester() {
		// TODO Auto-generated constructor stub
	}
	
	private static void display(Calculator calc) {
		System.out.printf("[%16.4f ]\n", calc.getCurrentValue()); // peek at value 
	}

	public static void main(String[] args) {
		// sample unit test 
		Calculator calculator = new Calculator(); // create new instance  
		display(calculator);
		
		calculator.add(7);
		calculator.add(9);
		display(calculator);
	
		calculator.square(); // perform math ops 
		display(calculator); 
		calculator.invert();   
		display(calculator); 
		
		calculator.invert();  
		calculator.percentage(10);  
		display(calculator);
		
		calculator.clear();  
		display(calculator);
		
	}

}
