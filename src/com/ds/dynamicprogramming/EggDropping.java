package com.ds.dynamicprogramming;

public class EggDropping {

	public int calculate(int eggs, int floors) {

		int dp[][] = new int[eggs + 1][floors + 1];
		int c = 0;
		for (int i = 0; i <= floors; i++) {
			dp[1][i] = i;
		}

		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				dp[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					c = 1 + Math.max(dp[e - 1][k - 1], dp[e][f - k]);
					dp[e][f] = Math.min(dp[e][f], c);
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
