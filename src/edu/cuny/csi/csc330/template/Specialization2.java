package edu.cuny.csi.csc330.template;

public class Specialization2 extends Specialization1 {

	public Specialization2() {
		instanceOfName = this.getClass().getSimpleName();
	}
	
	
	public void step2() {
		System.out.println("Specialization2  version of step2() in running");
		
	}


	public void step3() {
		System.out.println("Specialization2  version of step3() in running");
		
	}


	@Override
	public String toString() {
		return "Specialization2 [instanceOfName=" + instanceOfName + "]";
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
