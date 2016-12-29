package com.ds.sort;

import java.util.Arrays;

public class BinarySearchInRotatedArray {

	private static int binarySearchRotatedArray(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (a[lo] <= a[mid]) { // left portion is sorted half
				if (key > a[lo] && key < a[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (a[mid] <= a[hi]) { // right portion is sorted half
				if (key > a[mid] && key < a[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

	private static int binarySearchRotatedArrayRecursive(int[] a, int lo, int hi, int key) {
		if (lo > hi)
			return -1;
		int mid = (lo + hi) / 2;

		if (key == a[mid]) {
			return mid;
		}

		if (a[lo] <= a[mid]) { // left portion is sorted half
			if (key > a[lo] && key < a[mid]) {
				return binarySearchRotatedArrayRecursive(a, lo, mid - 1, key);
			} else {
				return binarySearchRotatedArrayRecursive(a, mid + 1, hi, key);
			}
		} else { // right portion is sorted half
			if (key > a[mid] && key < a[hi]) {
				return binarySearchRotatedArrayRecursive(a, mid + 1, hi, key);
			} else {
				return binarySearchRotatedArrayRecursive(a, lo, mid - 1, key);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 10, 11, 12, 13, 6, 7, 8, 9 };
		// int[] a = { 8, 9, 10, 1, 2, 3, 4, 5, 6 };
		System.out.println("Binary Search in Rotated Array: " + Arrays.toString(a) + ": ");
		System.out.println("Iterative:::::::");
		System.out.println("find 2: " + binarySearchRotatedArray(a, 2));
		System.out.println("find 5: " + binarySearchRotatedArray(a, 5));
		System.out.println("find 9: " + binarySearchRotatedArray(a, 9));
		// System.out.println("find 10: " + binarySearchRotatedArray(a, 10));
		System.out.println("find 13: " + binarySearchRotatedArray(a, 13));

		// recursive
		System.out.println("Recursive:::::::");
		System.out.println("find 2: " + binarySearchRotatedArrayRecursive(a, 0, a.length - 1, 2));
		System.out.println("find 5: " + binarySearchRotatedArrayRecursive(a, 0, a.length - 1, 5));
		System.out.println("find 9: " + binarySearchRotatedArrayRecursive(a, 0, a.length - 1, 9));
		// System.out.println("find 10: " + binarySearchRotatedArrayRecursive(a, 0, a.length - 1, 10));
		System.out.println("find 13: " + binarySearchRotatedArrayRecursive(a, 0, a.length - 1, 13));

	}

}
