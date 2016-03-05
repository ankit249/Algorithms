package com.ds.string;

import java.util.Arrays;
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
		char[] chara = string.toCharArray();
		int max = Integer.MIN_VALUE;

		int hi = 0;
		for (int i = 0; i < chara.length; i++) {

			if (!map.containsKey(chara[i])) {
				map.put(chara[i], i);
			} else {

				// if you only need length of the largestsubstring
				// max = Math.max(max, map.size());

				if (map.size() > max) {
					hi = i;
					max = map.size();
				}
				i = map.get(chara[i]); // loop starts from map.get plus one after for loop
				map.clear();
			}
		}

		// if you only need length of the largestsubstring
		// max = Math.max(max, map.size());
		// return max

		if (map.size() > max) {
			hi = chara.length - 1;
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

		System.out.println("acbdxx".indexOf('b'));

		System.out.println(Arrays.toString("Hi Hello Hi".split("[\\s+]")));

	}
}
