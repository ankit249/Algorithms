package com.ds.dynamicprogramming;

// O(n) space and O(n) time complexity
public class FibonacciDP {

	private static int fib(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(5));
	}
}
