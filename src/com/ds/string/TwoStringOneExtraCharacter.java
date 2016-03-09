package com.ds.string;

public class TwoStringOneExtraCharacter {

	private static char findDifferentChar(String s1, String s2) {
		boolean[] b = new boolean[256];

		for (int i = 0; i < s1.length(); i++) {
			b[s1.charAt(i)] = true;
		}
		char ch = '\0';
		for (int i = 0; i < s2.length(); i++) {
			if (!b[s2.charAt(i)]) {
				ch = s2.charAt(i);
				break;
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		String s1 = "ankit";
		String s2 = "anbkit";

		System.out.println(findDifferentChar(s1, s2));
	}


}
