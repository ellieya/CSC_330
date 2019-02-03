package edu.cuny.csi.csc330.template;

public abstract class Generalization {
	
	protected String instanceOfName; 
	

	public Generalization() {
		instanceOfName = this.getClass().getSimpleName();
	}
	
	public final void  execute(String instance) {
		System.out.println(instance + " is invoking execute()\n");
		
		step1();
		step2();
		subStep21();
		subStep22();
		step3();
		
		finish();  
		
	}
	
	public void step1() {
		System.out.println("Generalization version of step1() in running");
		
	}
	
	public void step2() {
		System.out.println("Generalization version of step2() in running");
		
	}
	
	public abstract void subStep21(); 
	
	public abstract void subStep22(); 
	
	public void step3() {
		System.out.println("Generalization version of step3() in running");
	}
	
	public void finish() {
		System.out.println("Generalization  version of finish() in running");
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
