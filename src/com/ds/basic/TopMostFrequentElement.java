package com.ds.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Given a non-empty array of integers, return the k most frequent elements.
public class TopMostFrequentElement {

	private static int topMostFrequentElement(int[] a) {
		System.out.println("Initial Array: \n" + Arrays.toString(a));

		// 1. build a map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int element : a) {
			Integer count = map.get(element);
			map.put(element, count == null ? 1 : count + 1);
		}
		System.out.println("Initial Map: \n" + map.toString());

		// 2. popular element
		Integer popular = Collections.max(map.entrySet(), new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		}).getKey();

		return popular;
	}

	public static void main(String[] args) {
		// find top 3 frequent ele
		int[] a = { 1, 1, 3, 4, 5, 6, 6, 7, 7, 7, 2 };
		System.out.println("Result is: " + topMostFrequentElement(a));

	}
}
