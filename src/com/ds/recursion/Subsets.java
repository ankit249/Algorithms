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
public class Subsets {

	public static List<List<Integer>> getSubsets(List<Integer> input) {
		var results = new ArrayList<List<Integer>>();
		helper(input, 0, new ArrayList<Integer>(), results);
		return results;
	}

	private static void helper(List<Integer> input, int pos, List<Integer> slate, List<List<Integer>> results) {
		// (1) basecase
		if(pos >= input.size()) {
			results.add(new ArrayList<Integer>(slate));
			return;
		}

		// (2) recursion
		slate.add(input.get(pos));
		helper(input, pos + 1, slate, results);
		slate.remove(slate.size() - 1);   //  (3) unmodify
											    //      remove is needed, if in doubt in any recursion always use remove
		helper(input, pos + 1, slate, results);
	}


	public static void main(String[] args) {

		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		List<List<Integer>> result = getSubsets(input);
		System.out.println(result);

		//System.out.println(1 << 3);
		//System.out.println(1 >> 1);

		input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(2);
		result = getSubsetsDups(input);
		System.out.println(result);
	}

/*
 *    WHAT TO DO if there is duplicate [1, 2, 2]
 *
 *                             []
 *                 /                       \
 *                /                         \
 *               [1]                       []           handle 1
 *             /    \                    /     \
 *         [1,2]     [1]              [2]       []      handle 2
 *          / \      /   \            / \       / \
 *    [1,2,2] [1,2] [1,2] [1]    [2,2]   [2]  [2]  []    handle 3
 *                  ---                       ---
 *   you can remove dups, but it'be nicer to not add dup, here [1,2] and [2] has dups
 *
 *   Answer is sort the array and don't add the underlined set, don't proceed to the next number, but proceed to a non duplicate number (pos + x)
 *
 */

	public static List<List<Integer>> getSubsetsDups(List<Integer> input) {
		var results = new ArrayList<List<Integer>>();
		Arrays.sort(input.toArray());
		helperDups(input, 0, new ArrayList<Integer>(), results);
		return results;
	}

	private static void helperDups(List<Integer> input, int pos, List<Integer> slate, List<List<Integer>> results) {
		// (1) basecase
		if(pos >= input.size()) {
			results.add(new ArrayList<Integer>(slate));
			return;
		}

		//(2) recursion
		slate.add(input.get(pos));
		helperDups(input, pos + 1, slate, results);
		slate.remove(slate.size() - 1);   //  (3) unmodify
												//      remove is needed, if in doubt in any recursion always use remove

		int x = nextdiff(input, pos);
		helperDups(input, pos + x, slate, results);
	}

	private static int nextdiff(List<Integer> input, int pos) {
		for(int i = pos + 1; i < input.size(); i++) {
			if(input.get(pos) != input.get(i)) {
				return  i;
			}
		}
		return  input.size();
	}


    /*
    NON RECURSIVE
     */

	List<ArrayList<Integer>> getSubsets2(List<Integer> set) {
		List<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();

		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while (k > 0) {
				if ((k & 1) > 0) {
					subset.add(set.get(index));
				}
				k >>= 1;
				index++;
			}
			allsubsets.add(subset);
		}
		return allsubsets;
	}


}
