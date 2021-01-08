package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

// bruteforce,
// time complexity O(2n)   <-- Exponential
public class SubsetOfSum_2 {

	/*
	 * Complete the function below.
	 */

	private static boolean slate = false;
	static boolean check_if_sum_possible(long[] arr, long k) {
		slate = false;
		boolean atleastone = false;
		helper(arr, 0, k, atleastone);
		return slate;
	}

	private static void helper(long[] input, int pos, long target, boolean atleastone) {

		if (target == 0 && atleastone) {
			slate = true;
			return;
		}

		if (pos >= input.length) {
			return;
		}


		// select the start index in the current sum

		helper(input, pos + 1, target - input[pos], true);

		// don't select the start index in the current sum
		helper(input, pos + 1 ,  target, atleastone);
	}

	public static void main(String[] args) {
		long[] input = {10, 20};
		int target = 0;
		System.out.println(check_if_sum_possible(input, target));
	}
}
