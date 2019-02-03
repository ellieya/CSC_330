package edu.cuny.csi.csc330.template;

public abstract class SomeClient {
	

	public SomeClient() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Generalization algorithm = new Specialization1();
		
		algorithm.execute(algorithm.toString()); 

	}

}
