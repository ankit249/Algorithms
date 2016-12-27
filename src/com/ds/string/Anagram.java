package com.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		System.out.println(anagram(str));
	}

	private static Map<String, ArrayList<String>> anagram(String[] strs) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		if (strs == null || strs.length == 0) {
			return map;
		}

		for (String s : strs) {
			char[] arr = new char[26];

			// either sort array or find out array of chars..
			for (int i = 0; i < s.length(); i++) {
				arr[s.charAt(i) - 'a']++;
			}
			String t = new String(arr);
			// String t = String.copyValueOf(Arrays.sort(s.toCharArray()));
			
			if (map.containsKey(t)) {
				/*
				 * ArrayList<String> list = map.get(t); list.add(s); map.put(t, list);
				 */
				map.get(t).add(s);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(t, list);
			}
		}

		// print map
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " :" + entry.getValue());
		}

		return map;
	}
}
