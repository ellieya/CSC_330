package edu.cuny.csi.csc330.examples2;

import java.util.Arrays;

public class ArrayDemo {

	public ArrayDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int[][] fiveTimesTable = new int[][]{
				  { 1, 2, 3, 4, 5},
				  { 2, 4, 6, 8, 10},
				  { 3, 6, 9, 12 , 15},
				  { 4, 8, 12, 16, 20},
				  { 5, 10 ,15, 20 ,25}
				};
		
		int[][] timesTable; 
		
		timesTable = new int[10][10];
		
		System.out.println(timesTable.length);
		
		System.out.println(timesTable);
		System.out.println(Arrays.toString(timesTable));
		System.out.println(Arrays.toString(fiveTimesTable));
		
		

	}

}
