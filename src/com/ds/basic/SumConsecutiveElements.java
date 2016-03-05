package com.ds.basic;

public class SumConsecutiveElements {
	public static boolean solution(int[] a, int target) {
		if (a.length == 0) {
			return target == 0;
		}
		int lo = 0;
		int hi = 0;
		int sum = a[0];
		if (sum == target) {
			return true;
		}
		while (hi < a.length) {
			if (sum > target) {
				sum -= a[lo];
				lo++;
			} else {
				hi++;
				if (hi < a.length) {
					sum += a[hi];
				}
			}
			if (sum == target) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(": " + solution(new int[] { 1, 2, 3, 4 }, 3));
	}
}
