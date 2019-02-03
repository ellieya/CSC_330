package edu.cuny.csi.csc330.recursion;

/**
This program demonstrates the recursive rangeSum method.
*/

public class Adder  {
	
	public static int rangeSum(int[] array, int start, int end)
	{
		if (start > end)
			return 0;
		else
			return array[start] + rangeSum(array, start + 1, end);
	}
	
	
	public static void main(String[] args)
	{
		int[] numbers = { 2, 4, 8, 16, 32, 64, 128, 256 };
		
		System.out.print("The sum of elements 1 through 5 is " + 
					rangeSum(numbers, 1, 5));
	}
	
	

}
