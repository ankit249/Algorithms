package com.ds.basic;

import java.util.Arrays;



public class RemoveDuplicates {

	// Remove duplicates from array in place
	// For example, given input array A = [1,1,2],
	// your function should return A is now [1,2].
	private static int[] removeDuplicates(int[] a) {
		if (a.length < 2) return a;

		int i = 0;
		int j = 1;

		while (j < a.length) {
			if (a[i] == a[j]) {
				j++;
			} else {
				i++;
				a[i] = a[j];
				j++;
			}
		}

		System.out.println(Arrays.toString(a));
		int[] b = Arrays.copyOf(a, i + 1);
		return b;
	}

	// this is not right
	// use http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/

	// Remove duplicates from array in place,
	// at most 2 is allowed
	// For example, given input array A = [1,1,2,2,2,3,3,3],
	// your function should return A is now [1,1,2,2,3,3].
	private static int[] removeDuplicateII(int[] a) {
		if (a.length < 3)
			return a;

		int i = 0;
		int j = 1;
		int k = 2;

		while (k < a.length) {
			if (a[i] == a[j] && a[j] == a[k]) {
				j++;
				k++;
			} else {
				i++;
				a[i] = a[j];
				j++;
				a[j] = a[k];
				k++;
			}
		}

		int[] b = Arrays.copyOf(a, i + 2);
		return b;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 3 };
		System.out.println(Arrays.toString(removeDuplicates(a)));

		int[] a2 = { 1, 1, 2, 2, 2, 3, 3, 3 };
		System.out.println(Arrays.toString(removeDuplicateII(a2)));

		int[] a3 = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(removeDuplicateII(a3)));

		int[] a4 = { 1, 2, 2, 2, 2, 3, 4, 4 };
		System.out.println(Arrays.toString(removeDuplicateII(a4)));

	}
}
