package com.ds.sort;


public class kthLargest {
	public static int getKth(int[] a, int k, int lo, int hi) {
		int i = lo + 1;
		int j = hi;

		while (i < j) {

			while (a[lo] <= a[i]) {
				i++;
			}

			while (a[lo] > a[j]) {
				j--;
			}

			if (i < j) {
				swap(a, i, j);
			}
		}

		swap(a, lo, j);

		if (k == j + 1) {
			return a[j];
		} else if (k > j + 1) {
			return getKth(a, k, j + 1, hi);
		} else {
			return getKth(a, k, lo, j - 1);
		}
	}

	public static void swap(int[] a, int n1, int n2) {
		int tmp = a[n1];
		a[n1] = a[n2];
		a[n2] = tmp;
	}

	public static void main(String[] args) {
		int[] a = { 50, 20, 6, 56, 61, 91 };
		System.out.println(getKth(a, 2, 0, a.length - 1));

		// 6, 20, 50, 56, 61, 91
	}

}
