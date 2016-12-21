package com.ds.basic;

import java.util.Arrays;

public class MergeSortedArrayTwo {
	public static void merge(int a[], int m, int b[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i > -1 && j > -1) a[k--] = (a[i] > b[j]) ? a[i--] : b[j--];
		while (j > -1) a[k--] = b[j--];
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int[] b = { 2, 4, 6, 8 };
		int m = 4;
		int n = 4;

		merge(a, m, b, n);
		System.out.println(Arrays.toString(a));
	}
}
