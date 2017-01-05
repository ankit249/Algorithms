package com.ds.basic;

public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int a[], int b[]) {
		int m = a.length;
		int n = b.length;

		// odd
		if ((m + n) % 2 != 0)
			return (double) findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
		// even
		else {
			return (double)(findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) / 2;
		}
	}

	public static int findKth(int a[], int b[], int k, int alo, int ahi, int blo, int bhi) {

		int aLen = ahi - alo + 1;
		int bLen = bhi - blo + 1;

		// Handle special cases
		if (aLen == 0)
			return b[blo + k];
		if (bLen == 0)
			return a[alo + k];
		if (k == 0)
			return a[alo] < b[blo] ? a[alo] : b[blo];

		// TODO RATTA
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + alo;
		bMid = bMid + blo;

		if (a[aMid] > b[bMid]) {
			k = k - (bMid - blo + 1);
			ahi = aMid;
			blo = bMid + 1;
		} else {
			k = k - (aMid - alo + 1);
			bhi = bMid;
			alo = aMid + 1;
		}

		return findKth(a, b, k, alo, ahi, blo, bhi);
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
