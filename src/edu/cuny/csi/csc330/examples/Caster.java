package edu.cuny.csi.csc330.examples;

public class Caster {

	public Caster() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i1 = 5;
		int i2 = 3; 
		
		System.out.println("Casted: " + ((float) i1/i2 )); 
		System.out.println("UnCasted: " + ( i1/i2) ); 
		
		int [] numberArray = {2, 4, 8, 16, 32, 64}; 
		
		Double rand = Math.random(); 
		Integer max = Math.max(512, 1024); 
		System.out.println(rand ); 
		System.out.println(max ); 
		
		
	}

}
