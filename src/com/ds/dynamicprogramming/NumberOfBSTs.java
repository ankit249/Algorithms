package com.ds.dynamicprogramming;

/*
For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

public class NumberOfBSTs {

	public static int numTrees(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i] = dp[i] + dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}
