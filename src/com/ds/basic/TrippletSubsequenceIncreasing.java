package com.ds.basic;

public class TrippletSubsequenceIncreasing {

	private static boolean isIncreasingTrippletSubsequence(int[] a) {
		int count = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				count++;
			} else {
				count = 1;
			}

			if (count == 3) {
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

	}
}
