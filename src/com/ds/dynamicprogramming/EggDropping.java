package com.ds.dynamicprogramming;

//https://www.youtube.com/watch?v=3hcaVyX00_4
public class EggDropping {

	public int calculate(int eggs, int floors) {

		int dp[][] = new int[eggs + 1][floors + 1];
		int c = 0;
		for (int i = 0; i < floors + 1; i++) {
			dp[1][i] = i;
		}

		for (int i = 2; i < eggs + 1; i++) {
			for (int j = 1; j < floors + 1; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k < j + 1; k++) {
					c = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
					dp[i][j] = Math.min(dp[i][j], c);
				}
			}
		}
		return dp[eggs][floors];
	}

	public int calculateRecursive(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		int min = 1000;
		for (int i = 1; i <= floors; i++) {
			int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
			if (val < min) {
				min = val;
			}
		}
		return min;
	}

	public static void main(String args[]) {
		EggDropping ed = new EggDropping();
		int r = ed.calculate(3, 100);
		System.out.println(r);
	}
}
