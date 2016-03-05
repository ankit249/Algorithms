package com.ds.recursion;

import java.util.ArrayList;

public class StringPermutations {

	public static ArrayList<String> getPermutations(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() == 0) {
			result.add("");
			return result;
		}
		char first = s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words = getPermutations(remainder);

		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) { // notice less than or equal to here...
				result.add(insertAtCharacter(word, first, i));
			}
		}
		return result;

	}

	private static String insertAtCharacter(String word, char ch, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);

		return start + ch + end;
	}

	public static void main(String[] args) {
		System.out.println(getPermutations("abc"));
	}
}
