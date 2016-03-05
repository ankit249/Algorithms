package com.ds.basic;

import java.util.Arrays;

// this approach sorts array which is O(NlogN)
// you can use set or map without sorting it would give O(N)
public class IntersectionOfArray {


	public static int[] intersectionOf(int[] a1, int[] a2) {
		Arrays.sort(a1);
		Arrays.sort(a2);

		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a1));

		int i = 0, j = 0, k = 0;
		int[] a = new int[Math.min(a1.length, a2.length)];

		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				i++;
			} else if (a1[i] > a2[j]) {
				j++;
			} else {
				a[k++] = a1[i];
				i++;
				j++;
			}
		}
		return Arrays.copyOf(a, k);
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 6 };
		int[] a2 = { 10, 2, 5, 1 };
		System.out.println(Arrays.toString(intersectionOf(a1, a2)));
	}
}
