package com.ds.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a random string S and another string T with unique elements, find the minimum consecutive sub-string of S such
 * that it contains all the elements in T. example: S='adobecodebanc' T='abc' answer='banc'
 * 
 **/
public class MatchStringSlidingWindow {
	private static int countMatches(int[] text, int[] pattern) {
		int match = 0;
		for (int i = 0; i < 256; i++) {
			if (pattern[i] > 0 && text[i] > 0) {
				match++;
			}
		}

		return match;
	}

	public static String minLenSubStringWithAllChars(String input, Set<Character> chars) {
		int[] text = new int[256];
		int[] pattern = new int[256];
		int start = 0;
		int end = 0;

		int minLen = Integer.MAX_VALUE;

		int resultStart = 0;
		int resultEnd = 0;

		// prepare the initial window of size of the char set
		for (char c : chars) {
			text[input.charAt(end)]++;
			pattern[c]++;
			end++;
		}

		while (start < input.length()) {
			int matches = countMatches(text, pattern);
			// if current window doesn't contain all the characters
			// then strech the window to right upto the end of string
			if (matches < chars.size() && end < input.length()) {
				// strech window
				text[input.charAt(end)]++;
				end++;
			}
			// if current window contains all the characters with frequency
			// at least one then we have the freedom to shrink the window
			// from front.
			else if (matches >= chars.size()) {
				// as current window contains all character so update minLen
				if (end - start < minLen) {
					minLen = end - start;
					resultStart = start;
					resultEnd = end;
				}
				// shrink window
				text[input.charAt(start)]--;
				start++;
			}
			// if current window doesn't cntains all chars
			// but we can't strech the window anymore then break
			else {
				break;
			}
		}

		return input.substring(resultStart, resultEnd);
	}

	public static void main(String[] args) {
		Set<Character> set = new HashSet<Character>();
		set.add('l');
		set.add('o');
		set.add('r');
		set.add('w');
		System.out.println(minLenSubStringWithAllChars("helloworld", set));
	}
}
