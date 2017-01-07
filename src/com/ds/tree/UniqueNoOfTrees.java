package com.ds.tree;

import java.util.Arrays;

public class UniqueNoOfTrees {
	public static int numTrees(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] = dp[i] + dp[j] * dp[i - j - 1];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numTrees(4));
	}

}
