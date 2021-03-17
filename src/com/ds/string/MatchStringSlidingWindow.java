package com.ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a random string S and another string T with unique elements, find the minimum consecutive sub-string of S such
 * that it contains all the elements in T. example: S='adobecodebanc' T='abc' answer='banc'
 * 
 **/
/*
/*
Concept: Controlling set
A Controlling set is a set of letters
CS = { 'l','r','w'}
"hello" --> not controlling because missing r,w
"hello world" --> controlling set because l,r,w covered


Problem: what is the length of shortest controlled substring

Questions
---------
Question? Empty CS ? --> empty set controls everything --> "" is controlled by empty set --> length 0
input dictionary for the input string is lowercase letters + space characters
controlling set is a set and it contains no duplicate
what to return for input string empty


Example
------
Input:  CS =  { 'l','r','w'}  string = "hello world"
Output: substring that represents "worl" - shortest substring which has l,r,w --> so the length is 4

Input: CS = {}, string="uiuiopuiopuo"
Output: 0 --> the substring ""

Input: CS = {} string=""
Output :0

Input: CS = {'l'} string="why"
Output : -1

Bruteforce approace --> generate all substrings and determine if they are controlled by the set, store the length of minimum controlled substring


 */


public class MatchStringSlidingWindow {

	// method 1:
	public static String minWindow(String s, String t) {
		if (t.length() > s.length()) return "";
		String result = "";

		// character counter for t
		HashMap<Character, Integer> target = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (target.containsKey(c)) {
				target.put(c, target.get(c) + 1);
			} else {
				target.put(c, 1);
			}
		}

		// character counter for s
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int lo = 0;
		int minLen = s.length() + 1;

		int count = 0; // the total of mapped characters
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (target.containsKey(c)) {
				if (map.containsKey(c)) {
					if (map.get(c) < target.get(c)) {
						count++;
					}
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
					count++;
				}
			}

			if (count == t.length()) {
				char sc = s.charAt(lo);
				while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
					if (map.containsKey(sc) && map.get(sc) > target.get(sc))
						map.put(sc, map.get(sc) - 1);
					lo++;
					sc = s.charAt(lo);
				}

				if (i - lo + 1 < minLen) {
					result = s.substring(lo, i + 1);
					minLen = i - lo + 1;
				}
			}
		}

		return result;
	}

	// method 2:
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
		int lo = 0;
		int hi = 0;

		int minLen = Integer.MAX_VALUE;

		int resultStart = 0;
		int resultEnd = 0;

		// prepare the initial window of size of the char set
		for (char c : chars) {
			text[input.charAt(hi)]++;
			pattern[c]++;
			hi++;
		}

		while (lo < input.length()) {
			int matches = countMatches(text, pattern);
			// if current window doesn't contain all the characters
			// then strech the window to right upto the end of string
			if (matches < chars.size() && hi < input.length()) {
				// strech window
				text[input.charAt(hi)]++;
				hi++;
			}
			// if current window contains all the characters with frequency
			// at least one then we have the freedom to shrink the window
			// from front.
			else if (matches >= chars.size()) {
				// as current window contains all character so update minLen
				if (hi - lo < minLen) {
					minLen = hi - lo;
					resultStart = lo;
					resultEnd = hi;
				}
				// shrink window
				text[input.charAt(lo)]--;
				lo++;
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
		set.add('r');
		set.add('w');
		System.out.println(minLenSubStringWithAllChars("hello world", set));
		//System.out.println(minWindow("helloworld", "llorw"));
	}
}
