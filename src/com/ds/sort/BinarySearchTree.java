package com.ds.sort;

public class BinarySearchTree {

	public static int binarySearch(int[] a, int key) {

		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == key)
				return mid;
			if (key < a[mid]) {
				hi = mid - 1;
			}
			if (key > a[mid]) {
				lo = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] a = { 0, 2, 2, 3, 4, 6, 9, 10, 12, 15 };

		System.out.println(binarySearch(a, 2));
	}
}
