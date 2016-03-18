package com.ds.sort;

public class BinarySearchInRotatedArray {

	private static int binarySearchRotatedArray(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == key)
				return mid;
			if (a[lo] < a[mid]) { // left portion is sorted half
				if (key > a[lo] && key < a[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (a[hi] > a[mid]) { // right portion is sorted half
				if (key > a[mid] && key < a[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 7, 8, 1, 2, 3 };

		System.out.println(binarySearchRotatedArray(a, 2));
		System.out.println(binarySearchRotatedArray(a, 5));
		System.out.println(binarySearchRotatedArray(a, 13));

		System.out.println("This is a FISH".replaceAll("IS", ""));
	}
}
