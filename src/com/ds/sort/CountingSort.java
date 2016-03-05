package com.ds.sort;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	private static void countSort(int[] a, int max) {
		int n = a.length;
		int[] countArray = new int[n];

		for (int i = 0; i < n; i++) {
			countArray[a[i]] = countArray[a[i]] + 1;
		}

		for (int i = 1; i < n; i++) {
			countArray[i] = countArray[i - 1] + countArray[i];
		}

		// inplace solution o(1) space
		int p = 0;
		int indx = 0;
		while (indx < countArray[p] && p < max) {
			a[indx++] = p;
			if (indx == countArray[p]) {
				p = p + 1;
			}
		}
		System.out.println("Output: " + Arrays.toString(a));

		/*
		for (int i = 0; i < n; i++) {
			int index = countArray[arr[i]] - 1;
			countArray[arr[i]] = countArray[arr[i]] - 1;
			sorted[index] = arr[i];
		}

		for (int k = 0; k < sorted.length; k++) {
			System.out.print(sorted[k] + " ");
		}
		*/

	}

	public static void main(String[] args) {
		int n = 10;

		Random random = new Random();
		int max = 3;
		int min = 0;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(max - min) + min;
		}

		System.out.println("Array Input: " + Arrays.toString(a));

		countSort(a, max);

	}
}
