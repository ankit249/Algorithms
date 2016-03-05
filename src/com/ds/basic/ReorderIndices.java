package com.ds.basic;

import java.util.Arrays;

public class ReorderIndices {

	public static void main(String[] args) {
		char[] a = { 'C', 'D', 'E', 'F', 'G' };
		int[] b = { 3, 0, 4, 1, 2 };

		int n = b.length;
		for (int i = 0; i < n; i++) {
			if (i != b[i]) {
				swap(a, i, b[i]);
				swapindex(b, i, b[i]);
			}
		}

		System.out.println(Arrays.toString(a));
	}

	private static void swap(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static void swapindex(int[] b, int i, int j) {
		int tmp = b[i];
		b[i] = b[j];
		b[j] = tmp;
	}
}
