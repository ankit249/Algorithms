package com.ds.dynamicprogramming;

//https://www.youtube.com/watch?v=_Lf1looyJMU
/*

0 0 1 1 1 
1 0 1 1 1
0 1 1 1 1
1 0 1 1 1
 
 Minimum sub square matrix is 3 * 3
 */

public class MinimumSubsquareMatrix {
	private static int findMinSubSquareMatrix(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		int max = 0;

		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < cols + 1; j++) {
				if (a[i - 1][j - 1] != 0) {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		// if you want to return square return max * max
		return max;
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 0, 0, 1, 1, 1 }, 
								  { 1, 0, 1, 1, 1 }, 
								  { 0, 1, 1, 1, 1 }, 
								  { 1, 0, 1, 1, 1 }};
		System.out.println("minumum subsquare matrix size: " + findMinSubSquareMatrix(a));
	}

}
