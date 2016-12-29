package com.ds.sort;

public class BinarySearchInDuplicate {

	// exactly similir to BST just the if loop addition in the match case.
	private static int binarySearchDuplicate(int[] a, int key, boolean searchFirst) {
		int lo = 0;
		int hi = a.length - 1;
		int result = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				result = mid;
				if (searchFirst) {
					// if you want to search the first occurrence then go to the first half.
					hi = mid - 1;
				} else {
					// if you want to search the last occurrence then go the the second half.
					lo = mid + 1;
				}

			}

		}
		return result;
	}

	private static int binarySearchDuplicateRecursive(int[] a, int lo, int hi, int key, boolean searchFirst) {
		if (lo > hi) return lo;
		int mid = (lo + hi) / 2;
		if (key < a[mid]) {
			return binarySearchDuplicateRecursive(a, lo, mid - 1, key, searchFirst);
		} else if (key > a[mid]) {
			return binarySearchDuplicateRecursive(a, mid + 1, hi, key, searchFirst);
		} else {
			if (searchFirst) {
				return binarySearchDuplicateRecursive(a, lo, mid - 1, key, searchFirst);
			} else {
				return binarySearchDuplicateRecursive(a, mid + 1, hi, key, searchFirst);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 3, 3, 5, 5, 5, 5, 9, 9, 11 };
		int key = 5;
		System.out.println("Iterative:::::::");
		// search the first index of duplicate --> pass true
		int firstOccurence = binarySearchDuplicate(a, key, true);
		System.out.println(firstOccurence);

		// TODO --> if first occurence is -1 no need to check

		// search the first index of duplicate --> pass false
		int lastOccurence = binarySearchDuplicate(a, key, false);
		System.out.println(lastOccurence);

		// Total number of duplicates for the key would be
		System.out.println("Total number of keys found = " + (lastOccurence - firstOccurence + 1));

		// recursive
		System.out.println("Recursive:::::::");
		firstOccurence = binarySearchDuplicateRecursive(a, 0, a.length - 1, key, true);
		System.out.println(firstOccurence);

		// search the first index of duplicate --> pass false
		// NOTICE -1 at the end here
		lastOccurence = binarySearchDuplicateRecursive(a, 0, a.length - 1, key, false) - 1;
		System.out.println(lastOccurence);

		// Total number of duplicates for the key would be
		System.out.println("Total number of keys found = " + (lastOccurence - firstOccurence + 1));
	}
}
