package com.ds.dynamicprogramming;

public class LongestCommonSubstringDP {
	private static int longestCommonSubString(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		int max = 0;
		for (int i = 1; i < str1.length + 1; i++) {
			for (int j = 1; j < str2.length + 1; j++) {
				if (str1[i - 1] == str2[j - 1]) {
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
				+ longestCommonSubString(str1.toCharArray(), str2.toCharArray()));
	}

}
