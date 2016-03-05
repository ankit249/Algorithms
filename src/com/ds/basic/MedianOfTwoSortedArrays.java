package com.ds.basic;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];

		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < a.length) {
			c[k++] = a[i++];
		}

		while (j < b.length) {
			c[k++] = b[j++];
		}

		return c;
	}

	private static double medianOfTwoSortedArrays(int[] a, int[] b) {


		double median_a = findMedian(a);
		double median_b = findMedian(b);

		int[] new_array_a = new int[a.length / 2];
		int[] new_array_b = new int[b.length / 2];

		if (median_a == median_b) {
			return median_a;
		}

		if (median_a < median_b) {
			new_array_a = Arrays.copyOfRange(a, a.length / 2, a.length);
			new_array_b = Arrays.copyOfRange(b, 0, b.length / 2);
		} else {
			new_array_a = Arrays.copyOfRange(a, 0, a.length / 2);
			new_array_b = Arrays.copyOfRange(b, b.length / 2, b.length);
		}

		int[] c = merge(new_array_a, new_array_b);

		return findMedian(c);
	}

	private static double findMedian(int[] a) {


		double result;

		if (a.length % 2 == 0) {
			// even
			int r1 = a[(a.length / 2) - 1];
			int r2 = a[a.length / 2];
			result = (double) (r1 + r2) / 2;
		} else {
			// odd
			result = a[a.length / 2];
		}

		return result;

	}

	public static void main(String[] args) {
		int[] b = { 2, 3, 4, 4, 4, 6 };
		int[] a = { 6, 7, 7, 8, 9 };
		System.out.println(medianOfTwoSortedArrays(a, b));
	}
}
