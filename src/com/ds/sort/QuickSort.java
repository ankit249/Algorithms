package com.ds.sort;

import java.util.Arrays;

public class QuickSort {

	public static void quicksort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		quicksort(a, lo, j - 1);
		quicksort(a, j + 1, hi);
	}

	public static int partition(int[] a, int lo, int hi) {
		// lo is the pivot pointer and hence a[lo] is the pivot element

		int i = lo + 1;
		int j = hi;

		// repeat until i and j pointer cross
		while (i < j) {

			// increase i until a[i] < a[lo] and if its decreasing sorted want to make sure i doesn't go above hi.
			while (a[i] < a[lo] && i < hi) {
				i++;
			}

			// decrease j until a[j] > a[lo]
			while (a[j] > a[lo] && j > lo) {
				j--;
			}

			// exchange a[i] and a[j] if i and j not crossed
			if (i <= j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		// exchange a[lo] with a[j],
		// now a[lo] the pivot is in its proper position
		int tmp = a[lo];
		a[lo] = a[j];
		a[j] = tmp;

		return j;
	}

	public static void main(String[] args) {
		// int[] a = new int[] { 32, 16, 15, 18, 2, 40, 3, 38 };
		int[] a = new int[] { 37, 25, 42, 16, 48, 39, 63 };
		// System.out.println(partition(a, 0, a.length));
		// System.out.println(Arrays.toString(a));
		/*
		 
		int[] a = new int[] { 406, 157, 415, 318, 472, 46, 252, 187, 364, 481, 450, 90, 390, 35, 452, 74, 196, 312, 142,
				160, 143, 220, 483, 392, 443, 488, 79, 234, 68, 150, 356, 496, 69, 88, 177, 12, 288, 120, 222, 270, 441,
				422, 103, 321, 65, 316, 448, 331, 117, 183, 184, 128, 323, 141, 467, 31, 172, 48, 95, 359, 239, 209,
				398, 99, 440, 171, 86, 233, 293, 162, 121, 61, 317, 52, 54, 273, 30, 226, 421, 64, 204, 444, 418, 275,
				263, 108, 10, 149, 497, 20, 97, 136, 139, 200, 266, 238, 493, 22, 17, 39 }; 
				
		*/
		quicksort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}

}
