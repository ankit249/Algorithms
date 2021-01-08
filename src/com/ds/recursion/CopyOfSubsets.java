package com.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of distinct objects (e.g. numbers) return all substes
 *
 * input: [1, 2, 3]
 * output: [[],[1,2,3],[1,2],[1,3],[1],[2,3],[2],[3]]
 *
 *                             []
 *                 /                       \
 *                /                         \
 *               [1]                       []           handle 1
 *             /    \                    /     \
 *         [1,2]     [1]              [2]       []      handle 2
 *          / \      /   \            / \       / \
 *    [1,2,3] [1,2] [1,3] [1]    [2,3]   [2]  [3]  []    handle 3
 *
 *    basecase can't be length -- just by looking at the length you don't know what would be the exit condition
 *
 *    TC - O(2^n)
 *    SC - O(2^n . N) -- i have 2 to the power 3 subsets and each with maximum 3 size of subsets
 *
 */
public class CopyOfSubsets {

	public static List<int[]> getSubsets(int[] input) {
		var results = new ArrayList<int[]>();
		helper(input, 0, new int[input.length], results);
		return results;
	}

	private static void helper(int[] input, int pos, int[] slate, List<int[]> results) {
		// (1) basecase
		if(pos >= input.length) {
			results.add(slate);
			return;
		}

		// (2) recursion
		slate[pos] = input[pos];
		helper(input, pos + 1, slate, results);

		//slate.remove(slate.size() - 1);         //  (3) unmodify
											    //      remove is needed, if in doubt in any recursion always use remove
		helper(input, pos + 1, slate, results);
	}


	public static void main(String[] args) {

		int[] input = new int[] {1,2,3};
		List<int[]> result = getSubsets(input);
		for(int[] a: result) {
			System.out.println(Arrays.toString(a));
		}

	}




}
