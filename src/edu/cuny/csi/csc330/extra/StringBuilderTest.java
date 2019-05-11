package edu.cuny.csi.csc330.extra;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		StringBuilder x = new StringBuilder();
		x.append("Hi, this is part of a string.");
		x.append("/n")
		x.append("This is the continuation of that string.");
		
		System.out.println(x);
	}
}
