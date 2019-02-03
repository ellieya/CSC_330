package edu.cuny.csi.csc330.examples;

public class StackFrameDemo {

	// Called method 
	public void method(int i, String s) {
		
		int localInt; 
		float localFloat; 
		String ls = "Local Value"; 
		
		s = new String("new Value"); 
		i = 99; 
		System.out.println(s + " " + i ); 
		
	}
	
	public StackFrameDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	// calling method 
	public static void main(String[] args) {
		StackFrameDemo sfd = new StackFrameDemo();
		int i = 57; 
		String s = "Original Value"; 
		System.out.println(s + " " + i ); 
		sfd.method(i, s); 
		System.out.println(s + " " + i ); 
		
	}

}
