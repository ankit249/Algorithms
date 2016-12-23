package com.ds.basic;

import java.util.Arrays;

public class RemoveElementFromArrayPassedIn {

	/*
	 * Given an array and a value, remove all instances of that value in place and return the new length. (Note: The
	 * order of elements can be changed. It doesn't matter what you leave beyond the new length.)
	 */

	// return array (you can return the same array)
	private static int[] removeElement(int[] a, int element) {
		if (a.length < 2)
			return a;
		int i = 0;
		int j = 0;

		while (j < a.length) {
			if (a[j] == element) {
				j++;
			} else {
				a[i] = a[j];
				i++;
				j++;
			}
		}

		int[] b = Arrays.copyOf(a, i);
		return b;

	}


	public static void main(String[] args) {
		int[] a = { 4, 4, 1, 2, 3, 4, 4, 5, 6, 4, 7 };
		System.out.println(Arrays.toString(removeElement(a, 4)));

		int[] b = { 1, 2, 3, 5, 6, 7 };
		System.out.println(Arrays.toString(removeElement(b, 4)));

		int[] c = { 1, 2, 3, 5, 6, 7, 4, 4, 4 };
		System.out.println(Arrays.toString(removeElement(c, 4)));

	}

}
