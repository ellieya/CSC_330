package edu.cuny.csi.csc330.template;

public class Specialization1 extends Generalization {

	public Specialization1()  {
		instanceOfName = this.getClass().getSimpleName();
	}
	

	@Override
	public String toString() {
		return "Specialization1 [instanceOfName=" + instanceOfName + "]";
	}

	
	

	public void step2() {
		System.out.println("Specialization1 version of step2() in running");
		
	}
	
	public void subStep21() {
		System.out.println("Specialization1  version of subStep21() in running");
		
	}
	
	public void subStep22() {
		System.out.println("Specialization1  version of subStep22() in running");
		
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
