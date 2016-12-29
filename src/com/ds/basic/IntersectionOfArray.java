package com.ds.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArray {

	// time: O(nlogn) space: O(n)
	public static int[] intersectionOf(int[] a1, int[] a2) {
		Arrays.sort(a1);
		Arrays.sort(a2);

		System.out.println("Array input 1: " + Arrays.toString(a1));
		System.out.println("Array input 2: " + Arrays.toString(a2));

		int i = 0, j = 0;
		List<Integer> list = new ArrayList<Integer>();

		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				i++;
			} else if (a1[i] > a2[j]) {
				j++;
			} else {
				list.add(a1[i]);
				i++;
				j++;
			}
		}

		int[] result = new int[list.size()];
		for (int p = 0; p < list.size(); p++) {
			result[p] = list.get(p);
		}

		return result;
	}

	// time: O(n) space: O(n)
	private static int[] interSectionWithMap(int[] a, int[] b) {

		System.out.println("Array input 1: " + Arrays.toString(a));
		System.out.println("Array input 2: " + Arrays.toString(b));

		List<Integer> list = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer element : a) {
			Integer value = map.get(element);
			map.put(element, value == null ? 1 : value + 1);
		}

		for (Integer e : b) {
			if (map.containsKey(e)) {
				if (map.get(e) > 1) {
					map.put(e, map.get(e) - 1);
				} else {
					map.remove(e);
				}
				list.add(e);
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println("Using method 1 sorting");
		System.out.println("----------------------");

		int[] a1 = { 1, 2, 6 };
		int[] a2 = { 10, 2, 5, 1 };
		System.out.println(Arrays.toString(intersectionOf(a1, a2)));

		int[] b1 = { 1, 2, 2 };
		int[] b2 = { 2, 3, 2, 4 };
		System.out.println(Arrays.toString(intersectionOf(b1, b2)));

		System.out.println("Using method 2 map");
		System.out.println("------------------");
		System.out.println(Arrays.toString(interSectionWithMap(a1, a2)));
		System.out.println(Arrays.toString(interSectionWithMap(b1, b2)));
	}
}
