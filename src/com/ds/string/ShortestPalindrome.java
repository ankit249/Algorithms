package com.ds.string;

public class ShortestPalindrome {
	public static String shortestPalindrome(String s) {
		StringBuilder result = new StringBuilder();

		int lo = 0;
		int hi = s.length() - 1;

		while (lo < hi) {
			if (s.charAt(lo) == s.charAt(hi)) {
				lo++;
				hi--;
			} else {
				result.append(s.charAt(hi));
				hi--;
			}
		}
		return result.append(s).toString();
	}

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));
		System.out.println(shortestPalindrome("abcd"));
		System.out.println(shortestPalindrome("aaabcbaa"));// this testcase doesn't work
	}
}
