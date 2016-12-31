package com.ds.dynamicprogramming;

/*
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum 
of all numbers along its path.
*/

public class MinimumPathSumMatrixDP {

	public static int mimumPathSum(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < rows; i++) {
			dp[i][0] = dp[i - 1][0] + matrix[i][0];
		}

		for (int i = 1; i < cols; i++) {
			dp[0][i] = dp[0][i - 1] + matrix[0][i];
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
			}
		}

		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][3];

		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;

		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;

		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		printMatrix(matrix);

		System.out.println(mimumPathSum(matrix));
	}

	private static void printMatrix(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
