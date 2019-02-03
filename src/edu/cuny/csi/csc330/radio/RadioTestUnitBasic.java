package edu.cuny.csi.csc330.radio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RadioTestUnitBasic {

	private Radio radio; 
	
	@Before
	public void prereq() {
		radio = new Radio();
		System.out.println("In prereq()"); 
	}
	
	
	@After
	public void postreq() {
		radio.off(); 
		System.out.println("In postreq()"); 
	}
	

	@Test
	public void testOn() {
		radio.on();
		assertTrue( radio.isOn() );
	}

	@Test
	public void testOff() {
		radio.off();
		assertFalse( radio.isOn() );
		assertTrue( radio.isOn() == false  );  // another way of asserting the line above ... 
		// assertTrue( radio.isOn() == true  );
	}


	@Test
	public void testSetVolume() {
		radio.setVolume(15);
		assertTrue( radio.getVolume() > 0);
	}


}
