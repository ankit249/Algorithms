package com.ds.matrix;

public class MinimumPathSumBFS {

	public static int mimumPathSum(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = matrix[0][0];

		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + matrix[0][i];
		}

		for (int j = 1; j < m; j++) {
			dp[j][0] = dp[j - 1][0] + matrix[j][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i][j - 1] + matrix[i][j];
				} else {
					dp[i][j] = dp[i - 1][j] + matrix[i][j];
				}
			}
		}

		return dp[m - 1][n - 1];
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
