package com.ds.dynamicprogramming;

// O(n) space and O(n) time complexity
// series
//     n = 0, 1, 2, 3, 4, 5, 6
//fib(n) = 0, 1, 1, 2, 3, 5, 8
public class FibonacciDP {

	private static int fibDP(int n) {
		if(n == 0 || n == 1) return n;
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// Dynamic Programming
		System.out.println();
		System.out.println("Fibonacci with DP....");
		for (int i = 0; i <= 6; i++) {
			System.out.print(fibDP(i) + " ");
		}

	}
}
