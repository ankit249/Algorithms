package com.ds.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SequenceTask {

	private static void taskSequence(String input, int coldtime) {
		char[] arr = input.toCharArray();
		Map<String, Integer> unsortedMap = new TreeMap<String, Integer>();
		Arrays.sort(arr);

		char s = arr[0];
		int count = 1;
		int total_count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == s) {
				count++;
			} else {
				unsortedMap.put(String.valueOf(s), count);
				s = arr[i];
				count = 1;
			}
			total_count++;
		}

		if (total_count < arr.length) {
			unsortedMap.put(String.valueOf(s), count);
		}

		// this is how you sort a map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		// System.out.println(unsortedMap);
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		// System.out.println(sortedMap);

		total_count = 0;
		System.out.print("for input: " + input + " result is: ");
		while (true) {
			for (Map.Entry<String, Integer> element : sortedMap.entrySet()) {
				if (element.getValue() != 0) {
					System.out.print(element.getKey() + "");
					int value = element.getValue();
					value--;
					sortedMap.put(element.getKey(), value);
					total_count++;
				}
			}
			if (total_count >= input.length()) {
				break;
			}
			if (coldtime > 0) {
				System.out.print("_");
				coldtime--;
			}
		}

		System.out.println();

	}

	public static void main(String[] args) {
		taskSequence("ABDCCCCBBBBA", 3);
		taskSequence("ABBBAA", 2);
	}
}
