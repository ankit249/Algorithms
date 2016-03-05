package com.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		/*
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] input = new String[n];
		int[] output = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = scanner.next();
		}
		for (int i = 0; i < n; i++) {
			System.out.println(findAnagramNumber(input[i]));
		}
		*/

		String[] str = new String[] { "cat", "act", "tod", "tac", "dot", "kb" };
		System.out.println(anagrams(str));
	}

	public static List<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return result;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String t = String.valueOf(arr);
			if (map.get(t) == null) {
				map.put(t, 1);
			} else {
				map.put(t, map.get(t) + 1);
			}
		}

		for (String string : strs) {
			char[] arr = string.toCharArray();
			Arrays.sort(arr);
			String t = String.valueOf(arr);
			if (map.get(t) > 1) {
				result.add(string);
			}
		}

		return result;
	}



}
