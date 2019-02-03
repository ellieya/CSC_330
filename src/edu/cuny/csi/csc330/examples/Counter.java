/** 
 * This Class presents a simple example of method overloading - where 
 * more than 1 method implementations take on the same name, but have different signatures. 
 */
package edu.cuny.csi.csc330.examples;

public class Counter {
	
	private static final int DEFAULT_FROM = 1;
	private static final boolean DEFAULT_HORZ = false;

	public Counter() {
		
	}
	
	public void count(int to) {  
		count(Counter.DEFAULT_FROM, to, Counter.DEFAULT_HORZ); 
	}
	
	public void count(int from, int to) {  
		count(from, to, Counter.DEFAULT_HORZ);
	}
	
	public void count(int to, boolean horz) {  
		count(Counter.DEFAULT_FROM, to, horz);
	}
	
	public void count(int from, int to, boolean horz) {  
		
		for(int i = from ; i <= to ; i++) {
			System.out.printf("%4d ", i);
			if(horz == false) 
				System.out.printf("\n");
		}
		
		// The Java conditional operator - a simple if, then, else 
		System.out.printf( horz == true ? "\n\n" : "\n" );
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		if(args.length == 0 ) {
		
			// test the different count() method signatures ... 
			counter.count(10); 
			counter.count(11, 15); 
			counter.count(11, 17, true ); 
			counter.count(7, true ); 
 		
		} 
		else {
			int to = Integer.parseInt(args[0]); 
			counter.count(to, true);
		}
	}

}
