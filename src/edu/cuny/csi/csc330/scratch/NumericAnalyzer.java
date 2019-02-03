package edu.cuny.csi.csc330.scratch;

public class NumericAnalyzer {

	public static void main(String[] args) {

		if (args.length < 1) {

			System.out
					.println("No Arguments passed. Please pass numbers as arguments.");

		} else {

			int[] arr = new int[args.length];

			for (int i = 0; i < arr.length; i++) {

				arr[i] = Integer.parseInt(args[i]);

			}

			System.out.print("Numbers before sorted : ");

			for (int i = 0; i < arr.length; i++) {

				System.out.print(arr[i] + " ");

			}

			insertionSort(arr);

			double sum = 0;

			System.out.print("\nNumbers after sorted : ");

			for (int i = 0; i < arr.length; i++) {

				System.out.print(arr[i] + " ");

				sum = sum + arr[i];

			}

			System.out.println("\nSize of number list : " + arr.length);

			System.out.println("Average/mean value = " + sum / arr.length);

			int median;

			if (arr.length % 2 == 0)

				median = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;

			else

				median = arr[arr.length / 2];

			System.out.println("Median of numbers is : " + median);

			System.out.println("Min value : " + arr[0]);

			System.out.println("Max value : " + arr[arr.length - 1]);

			System.out.println("Sum of numbers : " + (int) sum);

			System.out.println("Range : " + arr[0] + " - "
					+ arr[arr.length - 1]);

			System.out.println("Difference of range : "
					+ (arr[arr.length - 1] - arr[0]));

			// The variance

			double variance = 0;

			double mean = sum / arr.length;

			for (int i = 0; i < arr.length; ++i) {

				variance += (arr[i] - mean) * (arr[i] - mean);

			}

			variance /= arr.length;

			// Standard Deviation

			double std = Math.sqrt(variance);

			System.out.println("Variance : " + variance);

			System.out.println("Standard deviation : " + std);

		}

	}

	public static void insertionSort(int array[]) {

		int n = array.length;

		for (int j = 1; j < n; j++) {

			int key = array[j];

			int i = j - 1;

			while ((i > -1) && (array[i] > key)) {

				array[i + 1] = array[i];

				i--;

			}

			array[i + 1] = key;

		}

	}

}