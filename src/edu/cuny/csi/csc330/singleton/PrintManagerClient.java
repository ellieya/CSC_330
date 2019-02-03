package edu.cuny.csi.csc330.singleton;

public class PrintManagerClient {

	public PrintManagerClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrintManager printManager = PrintManager.getInstance(); 
		
		printManager.submitJob(new StringBuilder ("Example Job 1"));
		printManager.submitJob(new StringBuilder ("Example Job 2"));
		
		
		System.out.println(printManager);
		
		PrintManager printManager2 = PrintManager.getInstance();  
		printManager2.submitJob(new StringBuilder ("Example Job 3"));
		
		System.out.println(printManager2);
		
		if(printManager2 == printManager )
			System.out.println("PrintManagers are one and the same instance");

	}

}
