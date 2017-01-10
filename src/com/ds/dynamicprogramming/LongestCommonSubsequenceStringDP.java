package com.ds.dynamicprogramming;

//https://www.youtube.com/watch?v=NnD96abizww
public class LongestCommonSubsequenceStringDP {

	private static int longestCommonSubSequence(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		
		/*
		No need for this since its already zeros
		for(int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		*/
		int max = 0;
		for (int i = 1; i < str1.length + 1; i++) {
			for (int j = 1; j < str2.length + 1; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		String str1 = "abxdyz";
		String str2 = "abd";


		System.out.println("Length of longest Common Subsequence:  "
				+ longestCommonSubSequence(str1.toCharArray(), str2.toCharArray()));
	}

}
