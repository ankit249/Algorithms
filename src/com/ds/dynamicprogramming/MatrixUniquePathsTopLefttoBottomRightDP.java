package com.ds.dynamicprogramming;

/*
 
A robot is located at the top-left corner of a m x n grid. 
It can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid.

*/
public class MatrixUniquePathsTopLefttoBottomRightDP {

	private static int findUniquePaths(int rows, int cols) {

		int[][] dp = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < cols; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		int rows = 3;
		int cols = 3;

		// for 3 * 3 matrix
		System.out.println("Calculate Unique Paths: " + findUniquePaths(rows, cols));
	}
}
