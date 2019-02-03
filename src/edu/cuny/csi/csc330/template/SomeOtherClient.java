package edu.cuny.csi.csc330.template;

public abstract class SomeOtherClient {
	

	public SomeOtherClient() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Generalization algorithm = new Specialization2();
		
		algorithm.execute(algorithm.toString()); 

	}

}
