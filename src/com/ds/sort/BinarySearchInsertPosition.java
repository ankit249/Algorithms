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
		while (true) { // notice the while(true)
			mid = (lo + hi) / 2;
			if (key == a[mid])
				return mid;
			if (key < a[mid]) {
				if (lo < mid) {
					hi = mid - 1;
				} else {
					return lo;
				}
			} else {
				if (hi > mid) {
					lo = mid + 1;
				} else {
					return hi + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6 }; // 5
		// int[] a = { 1, 2, 3, 6, 8, 10 }; // 9
		System.out.println(searchInsertPosition(a, 9));
	}
}
