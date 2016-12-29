package com.ds.sort;

//http://www.programcreek.com/2013/01/leetcode-search-insert-position/
//  Given a sorted array and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.

// Here are few examples.

// [1,3,5,6], 5 -> 2
// [1,3,5,6], 2 -> 1
// [1,3,5,6], 7 -> 4
// [1,3,5,6], 0 -> 0

// working code
public class BinarySearchInsertPosition {

	private static int searchInsertPosition(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}
	
	// same as iterative except the exit condition its lo > hi and not lo >= hi.
	private static int searchInsertPositionRecursion(int[] a, int lo, int hi, int key) {
		if (lo > hi) return lo;
		int mid = (lo + hi) / 2;
		if (key < a[mid]) {
			return searchInsertPositionRecursion(a, lo, mid - 1, key);
		} else if (key > a[mid]) {
			return searchInsertPositionRecursion(a, mid + 1, hi, key);
		} else {
			return mid;
		}
	}

	// [1,3,5,6], 5 -> 2
	// [1,3,5,6], 2 -> 1
	// [1,3,5,6], 7 -> 4
	// [1,3,5,6], 0 -> 0
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6 };
		System.out.println("Iterative:::::::");
		System.out.println(searchInsertPosition(a, 5)); // 2
		System.out.println(searchInsertPosition(a, 2)); // 1
		System.out.println(searchInsertPosition(a, 7)); // 4
		System.out.println(searchInsertPosition(a, 0)); // 0

		// recursive
		System.out.println("Recursive:::::::");
		System.out.println(searchInsertPositionRecursion(a, 0, a.length - 1, 5)); // 2
		System.out.println(searchInsertPositionRecursion(a, 0, a.length - 1, 2)); // 1
		System.out.println(searchInsertPositionRecursion(a, 0, a.length - 1, 7)); // 4
		System.out.println(searchInsertPositionRecursion(a, 0, a.length - 1, 0)); // 0
		// a={1,2,3,6,8,10}; // 9
		// System.out.println(searchInsertPosition(a, 8));
	}
}
