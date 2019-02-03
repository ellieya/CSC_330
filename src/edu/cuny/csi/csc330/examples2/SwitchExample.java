package edu.cuny.csi.csc330.examples2;

public class SwitchExample {

	public SwitchExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]); 
		
		switch(number)  {
		
			case 64:
		
			case 128:
			
			case 256: 
				System.out.println(256);
			case 512:
				System.out.println(512);
			case 1024:
				System.out.println(1024);
			default:
				System.out.println("Default");
			
		}	

	}

}
