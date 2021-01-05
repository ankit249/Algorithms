package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

// bruteforce,
// time complexity O(2n)   <-- Exponential
public class SubsetOfSum {

	public static List<String> subsetofsum(int[] input, int target) {
		var result = new ArrayList<String>();
		boolean[] slate = new boolean[input.length];
		helper(input, 0, slate, target, result);
		return result;
	}

	private static void helper(int[] input, int pos, boolean[] slate, int target, List<String> result) {
		if (target == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < slate.length; i++) {
				if (slate[i]) {
					sb.append(input[i] + "+");
				}
			}
			sb.deleteCharAt(sb.toString().length() - 1);
			result.add(sb.toString());
			return;
		}

		if (pos >= input.length) {
			return;
		}


		// select the start index in the current sum
		slate[pos] = true;
		helper(input, pos + 1, slate, target - input[pos], result);

		// don't select the start index in the current sum
		slate[pos] = false;
		helper(input, pos + 1, slate, target, result);
	}

	public static void main(String[] args) {
		int[] input = { 3, 2, 7, 1, 8, 4, 5, 6 };
		int target = 8;
		List<String> result = subsetofsum(input, target);
		System.out.println(result);
	}
}
