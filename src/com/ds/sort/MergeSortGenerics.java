package com.ds.sort;

import java.util.Arrays;

public class MergeSortGenerics<E> {

	public <T extends Comparable<T>> void mergeSort(T[] a, T[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = (lo + hi) / 2;
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	public <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
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
			else if (a[i].compareTo(a[j]) <= 0) {
				a[k] = aux[i++];
			}

			else {
				a[k] = aux[j++];
			}
		}
	}

	public static void main(String[] args) {

		Integer[] a = new Integer[6];
		a[0] = new Integer(2);
		a[1] = new Integer(1);
		a[2] = new Integer(4);
		a[3] = new Integer(3);
		a[4] = new Integer(-1);
		a[5] = new Integer(3);

		Integer[] aux = new Integer[a.length];
		MergeSortGenerics<Integer> m = new MergeSortGenerics<Integer>();
		m.mergeSort(a, aux, 0, a.length - 1);

		System.out.println(Arrays.toString(a));
	}
}
