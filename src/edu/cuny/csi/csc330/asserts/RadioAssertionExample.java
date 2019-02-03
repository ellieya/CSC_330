package edu.cuny.csi.csc330.asserts;

import edu.cuny.csi.csc330.radio.Radio;


public class RadioAssertionExample {

	public RadioAssertionExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * BY DEFAULT, ASSERTIONS ARE TURNED OFF!  THEY DON'T EXECUTE!
		 * TO TURN ON, YOU NEED TO RUN THE JVM WITH A "-ea" OPTION (Enable Assertions)
		 * HOW IS THAT DONE?? 
		 */
		
		Radio radio = new Radio(); 
		radio.on(); 
		
		assert radio.isOn() == true : "Invalid power state"; 
		
		radio.setVolume(9); 
		
		assert radio.getVolume() == 10 : "Unexpected Volume Level";
		
		System.out.println("BasicAssertionExample Exiting ...");

	}


}
