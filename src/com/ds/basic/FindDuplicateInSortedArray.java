package com.ds.basic;

public class FindDuplicateInSortedArray {
	public static void printDups(int[] a) {
		System.out.print("dups: ");
		int lo = 0;
		int hi = 1;
		while (hi < a.length) {
			if (a[lo] == a[hi]) {
				System.out.print(a[lo] + " ");
				while (hi < a.length && a[lo] == a[hi]) {
					lo++;
					hi++;
				}
			} else {
				lo++;
				hi++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 7, 7 };
		printDups(a);
	}
}
