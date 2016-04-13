package com.ds.basic;

public class TrippletSubsequenceIncreasing {

	private static boolean isIncreasingTrippletSubsequence(int[] a) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			int z = a[i];

			if (x >= z) {
				x = z;// update x to be a smaller value
			} else if (y >= z) {
				y = z; // update y to be a smaller value
			} else {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		System.out.println(isIncreasingTrippletSubsequence(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(isIncreasingTrippletSubsequence(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(isIncreasingTrippletSubsequence(new int[] { 5, 6, 7, 8, 10 }));
		System.out.println(isIncreasingTrippletSubsequence(new int[] { 3, 4, 6, 7, 9 }));
		System.out.println(isIncreasingTrippletSubsequence(new int[] { 1, 7, 6, 4, 5 }));
	}
}
