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


TC:    O(2^2k)
SC:    O(2^2k)

 */
public class Parenthesis {

	public static List<String> generateParenthesis(int k) {
		List<String> result = new ArrayList<String>();
		helper("", k, k, result);
		return result;
	}

	public static void helper(String slate, int left, int right, List<String> result) {
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
			helper(slate + "(", left - 1, right, result);
		}

		if (right > 0) {
			helper(slate + ")", left, right - 1, result);
		}
	}

	public static void main(String[] args) {
		int k = 3;

		List<String> list = generateParenthesis(k);
		System.out.println(list);

		// using char[] array
		char[] result = new char[k * 2];
		helperPrint(0, k, k, result);

	}

	private static void helperPrint(int count, int l, int r, char[] result) {
		if (l < 0 || r < l)
			return; // invalid state
		if (l == 0 && r == 0) {
			System.out.print(result); // found one, so print it
			System.out.print(" ");
		} else {
			if (l > 0) { // try a left paren, if there are some available
				result[count] = '(';
				helperPrint(count + 1, l - 1, r, result);
			}
			if (r > l) { // try a right paren, if there’s a matching left
				result[count] = ')';
				helperPrint(count + 1, l, r - 1, result);
			}
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

