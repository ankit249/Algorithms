package com.ds.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Given a non-empty array of integers, return the k most frequent elements.
public class TopKFrequentElements {

	private static List<Integer> topKFrequentElements(int[] a, int k) {
		List<Integer> result = new ArrayList<Integer>();
		System.out.println("Initial Array: \n" + Arrays.toString(a));

		// 1. build a map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int element : a) {
			Integer value = map.get(element);
			map.put(element, value == null ? 1 : value + 1);
		}
		System.out.println("Initial Map: \n" + map.toString());

		// 2. build another TreeMap based on the values of map.
		Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				int diff = map.get(o2) - map.get(o1);
				// TODO: RATTA
				return diff == 0 ? 1 : diff;
			}
		});
		treemap.putAll(map);
		System.out.println("Tree Map based on the sorted value count: \n" + treemap.toString());

		// 3. fill the result list
		int count = 0;
		for (Integer element : treemap.keySet()) {
			count++;
			result.add(element);
			if (count == k) {
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// find top 3 frequent ele
		int[] a = { 1, 1, 3, 4, 5, 6, 6, 7, 7, 7 };
		List<Integer> list = topKFrequentElements(a, 3);
		System.out.println("Result is: " + list.toString());

	}
}
