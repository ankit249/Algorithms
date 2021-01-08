package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

// bruteforce,
// time complexity O(2n)   <-- Exponential
public class SubsetOfSumLessThanTarget {

	public static List<List<Integer>> subsetofsumLessThan(int[] input, int target, int N) {
		var result = new ArrayList<List<Integer>>();
		helper(input, 0, new ArrayList<Integer>(), target, N, 0, result);
		return result;
	}

	static void helper(int[] input, int pos, List<Integer> slate, int target, int N, int sum, List<List<Integer>> result) {

		if(slate.size() > N) {
			return;
		}

		if(pos >= input.length && slate.size() == N && sum < target) {
			result.add(new ArrayList<Integer>(slate));
			return;
		}

		for(int i = pos; i < input.length; i++) {
			slate.add(input[pos]);
			helper(input, pos + 1, slate, target, N, sum + input[pos] , result);

			slate.remove(slate.size() - 1);
			helper(input, pos + 1, slate, target, N, sum, result);
		}


	}

	public static void main(String[] args) {
		int[] input = { 1,2,3,4 };
		int target = 12;
		int number_of_combination = 3;
		List<List<Integer>> result = subsetofsumLessThan(input, target, number_of_combination);
		System.out.println(result);
	}
}
