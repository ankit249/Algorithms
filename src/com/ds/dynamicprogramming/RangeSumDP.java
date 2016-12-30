package com.ds.dynamicprogramming;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class RangeSumDP {
	int[] sum;

	public RangeSumDP(int[] nums) {
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 5, 7 };
		RangeSumDP rangeSum = new RangeSumDP(a);
		System.out.println(rangeSum.sumRange(2, 4)); // adding index 2 to 4 inclusive
		System.out.println(rangeSum.sumRange(1, 3)); // adding index 1 to 3 inclusive
		System.out.println(rangeSum.sumRange(2, 3)); // adding index 2 to 3 inclusive

	}
}
