package com.ds.basic;

import java.util.Arrays;

public class RotateArray {

	// rotate array k times
	// o(n * k) time complexity in place solution with space o(1)
	public static int[] rotate(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = a.length - 1; j > 0; j--) {
				int tmp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = tmp;
			}
		}
		return a;
	}

	// rotate array k times
	// o(n) time complexity in place solution with space o(1)
	public static int[] rotateEff(int[] a, int k) {

		reverse(a, 0, k);
		reverse(a, k + 1, a.length - 1);
		reverse(a, 0, a.length - 1);

		return a;
	}

	public static void reverse(int[] a, int lo, int hi) {
		if (a == null || a.length == 1)
			return;
		while (lo < hi) {
			int tmp = a[lo];
			a[lo] = a[hi];
			a[hi] = tmp;
			lo++;
			hi--;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		a = rotate(a, k);
		System.out.println(Arrays.toString(a));

		a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		k = 3;
		System.out.println(Arrays.toString(rotateEff(a, k)));
	}
}
