package edu.cuny.csi.csc330.threads;

public class RunnableCounter implements Runnable {
	
	private static int INCREMENT = 10;
	private static int MAX = 5000;
	
	private String name; 

	public RunnableCounter(String name) {
		this.name = name; 
	}


	public void run() {
		
		for(int i = 0 ; i < MAX ; i += INCREMENT) {
			System.out.printf("%s %d\n", name, i);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// CREATE 3 INSTANCES OF RunnableCounter - which are all Threadable/Runnable 
		RunnableCounter td1 = new RunnableCounter("One"); 
		RunnableCounter td2 = new RunnableCounter("Two"); 
		RunnableCounter td3 = new RunnableCounter("Three"); 
		
		// Create 3 Thread Instances 
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		Thread t3 = new Thread(td3);
		
		// start all 3 threads ... (run in background )  
		t1.start();
		t2.start();
		t3.start(); 
		
		
	}

}
