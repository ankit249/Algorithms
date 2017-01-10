package com.ds.dynamicprogramming;

//https://www.youtube.com/watch?v=BysNXJHzCEs
public class LongestCommonSubstringDP {
	private static int longestCommonSubString(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} // no else here, they remain zeros
				max = Math.max(max, dp[i][j]);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String str1 = "abxdyz";
		String str2 = "ppabd";

		System.out.println("Length of longest Common substring:  "
				+ longestCommonSubString(str1, str2));
	}

}
