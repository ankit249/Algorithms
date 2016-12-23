package com.ds.sort;

import java.util.Arrays;

public class BinarySearchFindMinRotatedArray {

	// find minimum iterative
	private static int findMinimumInRotatedArray(int[] a) {
		
		if (a == null || a.length == 0) return -1;
		if (a.length == 1) return a[0];

		int mid = 0, lo = 0, hi = a.length - 1;

		// not rotated
		if (a[lo] < a[hi]) return a[lo];

		while (lo <= hi) {

			if (hi - lo == 1) {
				return a[hi];
			}

			mid = (lo + hi) / 2;

			if (a[mid] > a[hi]) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return a[lo];
	}

	public static void main(String[] args) {
		int[] aa = { 10, 11, 12, 13, 6, 7, 8, 9 };
		// int[] aa = { 8, 9, 10, 1, 2, 3, 4, 5, 6 };
		// int[] aa = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		System.out.println("Find Minimum in Rotated Array: " + Arrays.toString(aa) + ": ");
		System.out.println(findMinimumInRotatedArray(aa));
	}
}
