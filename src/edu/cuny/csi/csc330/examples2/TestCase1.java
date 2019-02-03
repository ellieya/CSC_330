package edu.cuny.csi.csc330.examples2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase1 {
	
	private int flag = 255; 

	@Test
	public void test1() {
		assertTrue( flag == 256);
		// fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		assertTrue( 2 == 1);
		// fail("Not yet implemented");
	}


}
