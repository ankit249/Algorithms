package com.ds.string;

public class StringUniqueChars {

	// O(n) time complexity and O(n) space complexity
	private static boolean isUniqueChars(String string) {
		boolean[] b = new boolean[26];
		for (int i = 0; i < string.length(); i++) {
			if (b[string.charAt(i) - 'a'] == false) { // or !b[string.charAt(i) - 'a']
				b[string.charAt(i) - 'a'] = true;
			} else {
				return false;
			}
		}

		return true;
	}


	// O(n) time complexity and o(1) space complexity
	private static boolean isUniqueChars2(String string) {
		int checker = 0;
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= 1 << val;
		}
		return true;
	}


	public static void main(String[] args) {
		System.out.println("ankit: " + isUniqueChars("ankit"));
		System.out.println("ankit: " + isUniqueChars2("ankit"));

		System.out.println("aankit: " + isUniqueChars("aankit"));
		System.out.println("aankit: " + isUniqueChars2("aankit"));

		System.out.println("zyxw: " + isUniqueChars("zyxw"));
		System.out.println("zyxw: " + isUniqueChars2("zyxw"));

		System.out.println("zzyyzeex: " + isUniqueChars("zzyyzeex"));
		System.out.println("zzyyzeex: " + isUniqueChars2("zzyyzeex"));

	}
}
