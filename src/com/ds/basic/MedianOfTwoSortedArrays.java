package com.ds.basic;


public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int a[], int b[]) {
		int len = a.length + b.length;

		// odd length
		if (len % 2 == 1) {
			return findKth(a, 0, b, 0, len / 2 + 1);
		}
		return (findKth(a, 0, b, 0, len / 2) + findKth(a, 0, b, 0, len / 2 + 1)) / 2.0;
	}

	// find kth number of two sorted array
	public static int findKth(int[] a, int a_start, int[] b, int b_start, int k) {
		if (a_start >= a.length) {
			return b[b_start + k - 1];
		}
		if (b_start >= b.length) {
			return a[a_start + k - 1];
		}

		if (k == 1) {
			return Math.min(a[a_start], b[b_start]);
		}

		int v1 = a_start + k / 2 - 1 < a.length ? a[a_start + k / 2 - 1] : Integer.MAX_VALUE;
		int v2 = b_start + k / 2 - 1 < b.length ? b[b_start + k / 2 - 1] : Integer.MAX_VALUE;

		if (v1 < v2) {
			return findKth(a, a_start + k / 2, b, b_start, k - k / 2);
		} else {
			return findKth(a, a_start, b, b_start + k / 2, k - k / 2);
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 4, 4, 6 };
		int[] b = { 6, 7, 7, 8, 9 };
		System.out.println(findMedianSortedArrays(a, b));

		int[] c = { 1, 12, 15, 26, 38 };
		int[] d = { 2, 13, 17, 30, 45 };
		System.out.println(findMedianSortedArrays(c, d));

		int[] aa = { 4, 5, 6, 7, 8 };
		int[] bb = { 1, 2, 3, 4, 5 };
		System.out.println(findMedianSortedArrays(aa, bb));

		int[] e = { 1, 2, 3, 4, 5 };
		int[] f = { 1 };
		System.out.println(findMedianSortedArrays(e, f));
	}
}
