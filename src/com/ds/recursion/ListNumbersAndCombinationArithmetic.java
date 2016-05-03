package com.ds.recursion;

import java.util.ArrayList;

public class ListNumbersAndCombinationArithmetic {
	public static boolean isReachable(ArrayList<Integer> list, int target) {
		if (list == null || list.size() == 0)
			return false;

		int i = 0;
		int j = list.size() - 1;

		ArrayList<Integer> results = getResults(list, i, j);

		for (int num : results) {
			if (num == target) {
				return true;
			}
		}

		return false;
	}

	public static ArrayList<Integer> getResults(ArrayList<Integer> list, int lo, int hi) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (lo > hi) {
			return result;
		} else if (lo == hi) {
			result.add(list.get(lo));
			return result;
		}

		for (int i = lo; i < hi; i++) {

			ArrayList<Integer> result1 = getResults(list, lo, i);
			ArrayList<Integer> result2 = getResults(list, i + 1, hi);

			for (int x : result1) {
				for (int y : result2) {
					result.add(x + y);
					result.add(x - y);
					result.add(x * y);
					if (y != 0)
						result.add(x / y);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 5, 6 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int element : a) {
			list.add(element);
		}
		System.out.println(isReachable(list, 33));
	}
}
