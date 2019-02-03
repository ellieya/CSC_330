package edu.cuny.csi.csc330.examples;

/**
 * Class that demonstrates pass-by-reference / multiple reference to one object 
 * 
 * Let's really understand references! 
 * 
 * @author lji
 *
 */
public class ReferenceDemo {

	private int counter;  
	
	public static void increment(ReferenceDemo referenceDemo) {  
		referenceDemo.increment(); 
	}
	
	
	// update 
	public void increment() {
		++counter; 
	}
	
	public int getCounter() {

		return counter; 
	}
	
	

	@Override
	public String toString() {
		return "ReferenceDemo [counter=" + counter + "]";
	}


	public ReferenceDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Reference 1 
		ReferenceDemo ref1 = new ReferenceDemo(); // create a new instance - the only instance!
		
		// Reference 2 
		ReferenceDemo ref2 = ref1; // 2nd reference pointing to the same instance 
							       // Note this does NOT create a copy of the instance/memory 
		
		// Reference 3 
		ReferenceDemo ref3 = ref1; // yet another reference 
		
		ref1.increment();  // update #1 
		System.out.println(ref1); 
		
		ref2.increment();  // update #2
		System.out.println(ref1); 
		
		ref3.increment();  // update #3
		System.out.println(ref1); 
		
		// pass any one of the 3 references into a method ... 
		ReferenceDemo.increment(ref1); // update #4
		System.out.println(ref1); 
		
		ReferenceDemo.increment(ref3); // update #5
		System.out.println(ref1); 
		
		System.exit(0);
	}

}
