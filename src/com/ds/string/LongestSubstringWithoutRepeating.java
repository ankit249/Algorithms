package com.ds.string;

import java.util.HashMap;
import java.util.Map;

// works for all the cases in the main program
public class LongestSubstringWithoutRepeating {


	private static String longestSubstringWithoutRepeatation(String string) {
		if (string == null || string == "") {
			return null;
		}

		if (string.length() == 1) {
			return string;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int max = Integer.MIN_VALUE;

		int hi = 0;
		for (int i = 0; i < string.length() - 1; i++) {

			if (!map.containsKey(string.charAt(i))) {
				map.put(string.charAt(i), i);
			} else {

				// if you only need length of the largestsubstring
				// max = Math.max(max, map.size());

				if (map.size() > max) {
					hi = i;
					max = map.size();
				}
				i = map.get(string.charAt(i)); // loop starts from map.get plus one after for loop
				map.clear();
			}
		}

		// if you only need length of the largestsubstring
		// max = Math.max(max, map.size());
		// return max

		if (map.size() > max) {
			hi = string.length() - 1;
			max = map.size();
		}

		return string.substring(hi - max, hi);
	}

	public static void main(String[] args) {

		System.out.println(longestSubstringWithoutRepeatation("abcabcbb"));
		System.out.println(longestSubstringWithoutRepeatation("xyzxxabcyzxyz"));
		System.out.println(longestSubstringWithoutRepeatation("bbbbbbb"));
		System.out.println(longestSubstringWithoutRepeatation("abcabcbb"));
		System.out.println(longestSubstringWithoutRepeatation(""));
		System.out.println(longestSubstringWithoutRepeatation(null));

		// System.out.println("acbdxx".indexOf('b'));

		// System.out.println(Arrays.toString("Hi Hello Hi".split("[\\s+]")));

	}
}
