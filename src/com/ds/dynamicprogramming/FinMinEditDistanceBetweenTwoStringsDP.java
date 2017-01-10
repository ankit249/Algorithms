package com.ds.dynamicprogramming;

/*
Explanation: https://www.youtube.com/watch?v=We3YDTzNXEk
Code: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another

Time complexity is O(m*n)
Space complexity is O(m*n)


Note: If you need to find weather two strings are one edit distance or not use this:
http://www.programcreek.com/2014/05/leetcode-one-edit-distance-java/
*/

/*
 for Strings abcde and abxdz ==> it should be 2.

	      '' a b c d e
	    '' 0 1 2 3 4 5 
	     a 1 0 1 2 3 4 
	     b 2 1 0 1 2 3
	     x 3 2 1 1 2 3
	     d 4 3 2 2 1 2
	 	 z 5 4 3 3 2 2
*/
public class FinMinEditDistanceBetweenTwoStringsDP {

	private static int minEditDistance(String s, String t) {

		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
				}
			}
		}
		
		return dp[m][n];
	}

	public static void main(String args[]) {

		System.out.printf("Minimum Edit Distance between %s and %s is:  %d",
				"azced", "abcdef", minEditDistance("azced", "abcdef"));
		System.out.println();

		System.out.printf("Minimum Edit Distance between %s and %s is: %d",
				"ab", "acd", minEditDistance("ab", "acd"));
		System.out.println();

		System.out.printf("Minimum Edit Distance between %s and %s is: %d",
				"abcd", "pqrs", minEditDistance("abcd", "pqrs"));
		System.out.println();

	}

}
