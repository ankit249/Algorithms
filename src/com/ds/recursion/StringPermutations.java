package com.ds.recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {

/*
								  slate
								[a, b, c]
				/				   |                          \
			[a, b, c]           [b, a, c]					[c, b, a]
		     /    \              /    \                       /     \
	  [a,b,c]   [a,c,b]    [b,a,c]   [b,c,a]              [c,b,a]  [c,a,b]


*/
	private static List<String> getAllPermuation(char[] input) {
		List<String> result = new ArrayList<String>();
		List<String> slate = new ArrayList<>();
		for(char ch: input) {
			slate.add(String.valueOf(ch));
		}
		helper(input, slate, 0, result);
		return result;
	}

	private static void helper(char[] input, List<String> slate, int placed, List<String> result) {
		if(placed >= input.length) {
			result.add(slate.toString());
			return;
		}

		for(int i = placed; i < slate.size(); i++) {
			swap(slate, i, placed);
			helper(input, slate, placed + 1, result);
			swap(slate, i, placed);
		}
	}

	private static void swap(List<String> slate, int i, int j) {
		String tmp = slate.get(i);
		slate.set(i, slate.get(j));
		slate.set(j, tmp);
	}


	public static void main(String[] args) {
		// IK Approach
		String input = "abc";
		List<String> results = getAllPermuation(input.toCharArray());
		System.out.println(results);

		// original approach
		System.out.println(getPermutations("abc"));
	}

	private static List<String> getPermutations(String s) {
		List<String> result = new ArrayList<String>();
		if (s.length() == 0) {
			result.add("");
			return result;
		}
		char first = s.charAt(0);
		String remainder = s.substring(1);
		List<String> words = getPermutations(remainder);

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


}
