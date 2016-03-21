package com.ds.dynamicprogramming;

//http://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
//https://www.youtube.com/watch?v=s6FhG--P7z0


public class SubsetOfSumDP {

	/*
	 * for sum = 6 and a[] = {3, 2, 7, 1}
	 * 
	 *     0 1 2 3 4 5 6
	 *   0 T F F F F F F
	 *   3 T F F T F F F
	 *   2 T F T T F T F
	 *   7 T F T T F T F
	 *   1 T T T T T T T
	 */
	private static boolean subsetDP(int[] a, int sum) {
		boolean[][] dp = new boolean[a.length + 1][sum + 1];

		for (int i = 0; i < a.length + 1; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i < a.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= a[i - 1] && dp[i][j] == false) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]];
				}
			}
		}

		return dp[a.length][sum];
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 1 };
		System.out.println("\nFrom DP: " + subsetDP(a, 3));
	}
}
