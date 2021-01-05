package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;


/*
Given a pair of parenthesis , generate all well formed strings

Example
Input: K=3, Output: ["()()()","()(())",(())()"
				      "((()))","(()())"]

Approach 1
----------
brute force "((((((","((((()","((())))" .... // O(2^2k)
this is waste because the no valid results can start with closing bracket )

recognize a state will never be valid and stopping early is called backtracking


Approach 2 Backtracking
-----------------------

keep track of left parenthesis still available, right parenthesis still available

													l=3, r=3,""
											/						      \
									l=2,r=3,"("                          l=3,r=2,")"  <-- not valid so backtrack
							/			       \
					l=1,r=3,"(("    	        l=2,r=2,"()"
        			  /       \                   /         \
  			l=0,r=3,"((("  l=1,r=2,"(()"	 l=1,r=2,"()("	 l=2,r=1,"())"   <-- not valid so backtrack








 if( l is more than right -- you backtrack)
 here you cut half of the tree with backtracking if you notice and draw the full tree


TC:    O(2^2k)  -- check with k=2 (look at the depth of tree - it will be length 4 - so 2^4)
SC:    O(2^2k)

 */
public class Parenthesis {

	private static List<String>  generateParenthesis(int k) {
		char[] slate = new char[k * 2];
		List<String> result = new ArrayList<String>();
		helper(k, k, 0, slate, result);
		return result;
	}

	private static void helper(int l, int r, int pos, char[] slate, List<String> result) {

		// backtracking - stop before we have reached the end (no need to go beyond this -- its optimization)
		if (l > r) {
			return;
		}

		// base case -- means we have reached the end
		if (l == 0 && r == 0) {
			result.add(new String(slate));
			return;

		}

		// since strings are immutable -- nothing to unmodify here, if you use char[] then you will have to unmodify
		// in practice don't use string since the price is very high for immutable strings, use char[]
		if (l > 0) {
			slate[pos] = '(';
			helper(l - 1, r, pos + 1, slate, result);
		}
		if (r > 0) {
			slate[pos] = ')';
			helper(l, r - 1, pos + 1, slate, result);
		}

	}

	public static void main(String[] args) {
		int k = 3;

		// using char[] array IK Style
		List<String> results = generateParenthesis(k);
		System.out.println(results);

		List<String> list = generateParenthesisString(k);
		System.out.println(list);
	}

	public static List<String> generateParenthesisString(int k) {
		List<String> result = new ArrayList<String>();
		helperString("", k, k, result);
		return result;
	}

	public static void helperString(String slate, int left, int right, List<String> result) {
		// backtracking - stop before we have reached the end (no need to go beyond this -- its optimization)
		if (left > right) {
			return;
		}

		// base case -- means we have reached the end
		if (left == 0 && right == 0) {
			result.add(slate);
			return;
		}

		// since strings are immutable -- nothing to unmodify here, if you use char[] then you will have to unmodify
		// in practice don't use string since the price is very high for immutable strings, use char[]
		if (left > 0) {
			helperString(slate + "(", left - 1, right, result);
		}

		if (right > 0) {
			helperString(slate + ")", left, right - 1, result);
		}
	}
}

/*

Better bound for TC / SC


Approach 3:
Use this to get better TC, put a pair in front, behind and around


											""

							"()"              "()"                 "()"

				"()()" "(())" "()()"      "()()" "(())" "()()"     .....





TC: O(3^K)

*/

