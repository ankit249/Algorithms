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

			// increase i until a[i] < a[lo]
			while (a[i] <= a[lo]) {
				i++;
			}

			// decrease j until a[j] > a[lo]
			while (a[j] > a[lo]) {
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
		int[] a = new int[] { 32, 16, 15, 18, 2, 40, 3, 38 };
		// int[] a = new int[] { 6, 2, 3, 4, 1, 6, 7, 7, 4, 4, 1, 2, 1 };
		// System.out.println(partition(a, 0, a.length));
		// System.out.println(Arrays.toString(a));
		quicksort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}

}
