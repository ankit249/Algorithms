package com.ds.basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	private static void findIndices(int[] a, int sum) {
		int index1 = -1;
		int index2 = -1;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				index1 = map.get(a[i]);
				index2 = i;
				System.out.println("index1: " + index1 + "; index2: " + index2);
				break;
			} else {
				map.put(sum - a[i], i);
			}

		}
	}

	public static void main(String[] args) {
		int[] a = { 11, 2, 15, 7 };
		findIndices(a, 9);
	}
}
