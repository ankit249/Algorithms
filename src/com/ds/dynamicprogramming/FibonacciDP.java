package com.ds.dynamicprogramming;

// O(n) space and O(n) time complexity
public class FibonacciDP {

	private static int fibDP(int n) {
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i < n + 1; i++) {
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
