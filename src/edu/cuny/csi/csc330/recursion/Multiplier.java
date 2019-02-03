package edu.cuny.csi.csc330.recursion;

/**
This program demonstrates the recursive rangeSum method.
*/

public class Multiplier  {
	
	public static int rangeProduct(int[] array, int start, int end)
	{
		if (start > end)
			return 1;
		else
			return array[start] * rangeProduct(array, start + 1, end);
	}
	
	
	public static void main(String[] args)
	{
		int[] numbers = { 2, 4, 8, 16, 32, 64, 128, 256 };
		
		System.out.print("The product of elements 2 through 5 is " + 
					rangeProduct(numbers, 2, 5));
	}
	
	

}
