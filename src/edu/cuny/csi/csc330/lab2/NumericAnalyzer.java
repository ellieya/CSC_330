package edu.cuny.csi.csc330.lab2;

/*
 * Remaining to-do:
 * Just need to covert all the computation methods into something less lazy and flexible
 */

import java.lang.Math;
import java.util.Arrays;

public class NumericAnalyzer {
	
	int[] intArgs;
	int
	size,
	min,
	max,
	range,
	sum = 0;
	
	double
	median,
	mean,
	variance,
	standardDeviation;
	
	@Override
	public String toString() {
		return "NumericAnalyzer [intArgs=" + Arrays.toString(intArgs) + "]";
	}
	
	public NumericAnalyzer(String[] args) {
		
		
		//INITIALIZE - Initialize size, and use it to initialize arrays
		size = args.length;
		intArgs = new int[size];
		int intHolder; //Temporarily holds data for swap
		
		//CONVERT TO INT - Take string arguments, covert to int, then store into intArgs
		for (int i = 0; i < size; i++) {
			intArgs[i] = Integer.parseInt(args[i]);
		}
		
		//SORT - sort list of integers (selection sort)
		int tempMin = 0; //Keeps current lowest known number's INDEX
		int tempCompleted = 0; //Keeps "size" of sorted thus far
		
		while (tempCompleted < size) {
			tempMin = tempCompleted;
			for (int i = tempCompleted; i < size; i++) {
				if (intArgs[tempMin] > intArgs[i])
					tempMin = i;
			}
			intHolder = intArgs[tempCompleted];
			intArgs[tempCompleted] = intArgs[tempMin];
			intArgs[tempMin] = intHolder;
			tempCompleted++;
		}
	}
	
	/**
	 * compute() - Runs through all compute methods in the correct order
	 */
	public void compute() {
		
		computeMin();
		computeMax();
		computeRange();
		
		computeSum();
		computeMean();
		computeMedian();
		computeVariance();
		computeStandardDeviation();
	}

	private void computeMin() {
		// Because the array is sorted, max is just first element
		min = intArgs[0];
	}

	private void computeMax() {
		//Because the array is sorted, max is just last element
		max = intArgs[size-1];
	}
	
	/**
	 * computeRange() - PRE: MAX and MIN must be calculated before RANGE 
	 */
	private void computeRange() {
		range = max - min;
	}

	private void computeSum() {
		for (int i = 0; i < intArgs.length; i++) {
			sum += intArgs[i];
		}
	}

	/**
	 * computeMean() - PRE: SUM must be calculated before MEAN 
	 */
	private void computeMean() {

		mean = (double) sum / size; //Cast to double before calculation
	}
	
	/**
	 * computeMedian() - PRE: SIZE must be calculated before MEDIAN 
	 */
	private void computeMedian() {
		median = size % 2 == 0 ? ((double)(intArgs[size/2 - 1] + intArgs[size/2])/2) : intArgs[size/2];
		
	}
	
	/**
	 * computeVariance() - PRE: MEAN must be calculated before VARIANCE 
	 */
	private void computeVariance() {
		
		double varianceSum = 0;
		
		for (int i = 0; i < intArgs.length; i++) {
			varianceSum += Math.pow(intArgs[i] - mean, 2);
		}
		
		variance = (double) varianceSum / size;
		
	}
	
	/**
	 * computeStandardDeviation() - PRE: VARIANCE must be calculated before STANDARDDEVIATION
	 */
	private void computeStandardDeviation() {
		standardDeviation = Math.sqrt(variance);
	}
	
	/**
	 * printResult() - PRE: compute() function must be run before use, or inaccurate numbers will be printed
	 */
	public void printResult() {
		System.out.println("Input (Sorted):");
		for (int i = 0; i < size; i++) {
			System.out.print(intArgs[i] + " ");
		}
		System.out.println("\n");
		
		System.out.printf("%-20s%10d %n", "Size:", size);
		System.out.printf("%-20s%10d %n", "Min:", min);
		System.out.printf("%-20s%10d %n", "Max:", max);
		System.out.printf("%-20s%10d %n", "Range:", range);
		System.out.printf("%-20s%10d %n", "Sum:", sum);
		
		//Doubles are rounded before printing
		System.out.printf("%-20s%10d %n", "Mean:", Math.round(mean));
		System.out.printf("%-20s%10d %n", "Median:", Math.round(median));
		System.out.printf("%-20s%10d %n", "Variance", Math.round(variance));
		System.out.printf("%-20s%10d %n", "Standard Deviation:", Math.round(standardDeviation));
		
	}
	
	public static void main(String[] args) {
		if(args.length == 0) {
			System.err.println("ERROR - Please enter 1 or more integers!");
			System.exit(1);
		}
		
		NumericAnalyzer numericAnalyzer = new NumericAnalyzer(args);
		numericAnalyzer.compute();
		numericAnalyzer.printResult();
		
		System.out.println("\nNumber analysis complete!");
	}
}
