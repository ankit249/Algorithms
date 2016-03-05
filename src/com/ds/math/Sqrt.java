package com.ds.math;

public class Sqrt {
	public static int sqrt(int n) {
		int sum = 1;
		int result = 0;

		int j = 0;

		while (result < n) {
			j++;
			result = result + sum;
			sum = sum + 2;
		}

		return j;
	}

	public static int sqrt_btree(int n) {
		if (n <= 0)
			return n;
		int lo = 1;
		int hi = n / 2;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid == n / mid) {
				lo = mid;
				break;
			} else if (mid > n / mid) {
				hi = mid;
			} else if (mid < n / mid && (mid + 1) <= n / (mid + 1)) {
				lo = mid + 1;
			} else if (mid < n / mid && (mid + 1) > n / (mid + 1)) {
				lo = mid;
				break;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		// System.out.println(sqrt_btree(10));

		System.out.println(sqrt(25));
	}
}
