package com.ds.sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

	
	public static void mergeSort(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + ((hi - lo) / 2 );
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);

	}

	public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[i] <= aux[j])
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
	}
	

	/*
	public static void mergeSort(int[] a, int[] b, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSort(a, b, lo, mid);
			mergeSort(a, b, mid + 1, hi);
			merge(a, b, lo, mid + 1, hi);
		}
	}

	public static void merge(int[] a, int[] b, int lo, int mid, int hi) {
		int leftEnd = mid - 1;
		int count = lo;
		int num = (hi - lo) + 1;

		while ((lo <= leftEnd) && (mid <= hi)) {
			if (a[lo] < a[mid]) {
				b[count++] = a[lo++];
			} else {
				b[count++] = a[mid++];
			}
		}

		while (lo <= leftEnd) {
			b[count++] = a[lo++];
		}

		while (mid <= hi) {
			b[count++] = a[mid++];
		}

		// Copy b back to a.
		for (int i = 0; i < num; i++, hi--) {
			a[hi] = b[hi];
		}

	}
	*/

	public static void main(String[] args) {

		// mergesort
		int[] a = { 9, 2, 6, 3, 5, 1 };
		int[] aux = new int[a.length];
		mergeSort(a, aux, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

		/*
		//mergesort while arraylist is given
		Integer[] array = { 9, 2, 6, 3, 5, 1 };
		List<Integer> list = Arrays.asList(array);
		System.out.println(list);
		*/

		// merge two sorted arrays
		int[] m = { 2, 3, 5, 6, 7 };
		int[] n = { 6, 7, 8, 9, 10 };
		int[] res = merge(m, n);
		System.out.println(Arrays.toString(res));
	}

	public static int[] merge(int[] a, int[] b) {
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

}