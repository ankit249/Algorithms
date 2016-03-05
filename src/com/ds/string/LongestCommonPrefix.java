package com.ds.string;

public class LongestCommonPrefix {
	private static String longestCommonPrefix(String[] strArray) {
		int min_length = Integer.MAX_VALUE;

		for (String string : strArray) {
			min_length = Math.min(min_length, string.length());
		}

		if (min_length == 0) {
			return "";
		}
		String result_prefix = "";
		for (int i = 1; i <= min_length; i++) {
			String prefix = strArray[0].substring(0, i);
			for (String string : strArray) {
				if (string.substring(0, i).equals(prefix)) {
					continue;
				} else {
					return result_prefix;
				}
			}
			result_prefix = prefix;
		}

		return null;
	}

	public static void main(String[] args) {
		String[] str = { "abc", "abxyz", "abcpq", "abdevliers" };
		System.out.println(longestCommonPrefix(str));
	}
}
