/**
 * This simple Class implementation demonstrates method overriding - and the facts that 
 * the Java platform is said to have "dynamic binding" .... 
 * 
 * This Class also highlights an example of method overloading ... 
 * 
 */
package edu.cuny.csi.csc330.examples;

//Why is this import statement required?? 
import edu.cuny.csi.csc330.lib.Randomizer;

public class Overrider {
	
	private int serialNumber;
	private String title; 

	public Overrider() {
		init(); 
	}
	
	private void init() {
		Randomizer randomizer = new Randomizer(); 
		serialNumber = randomizer.generateInt(10000000, 100000000);
		title = this.getClass().getName(); 
	}
	
	public void demo() {
		Object object = new Object(); 
		
		// invoke demo(Object) on instance of Object  
		demo(object); 
		
		// invoke demo(Object) on current instance 
		demo(this); 
		
	}
	
	public void demo(Object object ) {
		String className = object.getClass().getName(); 
		System.out.printf("Running toString() on %s:   %s\n",  
				className, object.toString()  );
	}
	

	@Override
	public String toString(int x) {
		return "Overrider [serialNumber=" + serialNumber + ", title="
				+ title + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Overrider demo = new Overrider();
		
		demo.demo(); 

		System.exit(0);
	}

}
