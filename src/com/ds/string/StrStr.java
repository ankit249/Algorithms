package com.ds.string;

public class StrStr {

	public static int strStr(String haystack, String needle) {

		if (needle == null || haystack == null)
			return -1;
		if (needle.length() > haystack.length())
			return -1;

		int nlength = needle.length();

		for (int i = 0; i <= haystack.length() - nlength; i++) {
			if (haystack.substring(i, i + nlength).equalsIgnoreCase(needle)) {
				return i;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "pi";
		System.out.println(strStr(haystack, needle));
	}
}
