package com.ds.dynamicprogramming;


import java.util.HashMap;
import java.util.Map;


public class FibonacciDP {

	// O(n) space and O(n) time complexity
	// series
	//     n = 0, 1, 2, 3, 4, 5, 6
	//fib(n) = 0, 1, 1, 2, 3, 5, 8
	/*
	This is bottom up tabulation approach <-- Always preferred over top down memoization
	 */
	private static int fibDPBottmUpTabulation(int n) {
		if(n == 0 || n == 1) return n;

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	// O(n) space and O(1) time complexity
	// series
	//     n = 0, 1, 2, 3, 4, 5, 6
	//fib(n) = 0, 1, 1, 2, 3, 5, 8
	/*
	This is bottom up tabulation approach <-- More efficient since it doesn't use the entire array
	 */
	private static int fibDPBottmUpTabulationEfficient(int n) {
		int[] dp = new int[3];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
		}
		return dp[n % 3];
	}

	// O(n) space and O(n) time complexity
	// series
	//     n = 0, 1, 2, 3, 4, 5, 6
	//fib(n) = 0, 1, 1, 2, 3, 5, 8
	/*
	This is top down memoization <-- not preferred in the interview
	 */
	private static Map<Integer, Integer> memo = new HashMap<>();
	private static int fibDPMemoization(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		memo.put(n, fibDPMemoization(n -1 ) + fibDPMemoization(n - 2));
		return memo.get(n);
	}


	public static void main(String[] args) {
		// Dynamic Programming
		System.out.println();
		System.out.println("Fibonacci with DP bottom up tabulation TC: O(N), SC: O(N)....");
		for (int i = 0; i <= 6; i++) {
			System.out.print(fibDPBottmUpTabulation(i) + " ");
		}

		System.out.println();
		System.out.println("Fibonacci with DP bottom up tabulation TC: O(N), SC: O(1)....");
		for (int i = 0; i <= 6; i++) {
			System.out.print(fibDPBottmUpTabulationEfficient(i) + " ");
		}

		System.out.println();
		System.out.println("Fibonacci with DP Top down Memoization TC: O(N), SC: O(N)....");
		for (int i = 0; i <= 6; i++) {
			System.out.print(fibDPMemoization(i) + " ");
		}

	}
}
