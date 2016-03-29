package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

	public static List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		dfs(result, "", n, n);
		return result;
	}

	/*
	 * left and right represents the remaining number of ( and ) that need to be added. When left > right, there are
	 * more ")" placed than "(". Such cases are wrong and the method stops.
	 */
	public static void dfs(ArrayList<String> result, String s, int left, int right) {
		if (left > right)
			return;

		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}

		if (left > 0) {
			dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			dfs(result, s + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		int num = 3;

		List<String> list = generateParenthesis(num);
		System.out.println(list);
        /*
		char[] str = new char[num * 2];
		printPar(num, num, str, 0);
		
		*/

	}
	
    /*
 	public static void printPar(int l, int r, char[] str, int count) {
		if (l < 0 || r < l)
			return; // invalid state
		if (l == 0 && r == 0) {
			System.out.print(str); // found one, so print it
			System.out.print(" ");
		} else {
			if (l > 0) { // try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}

			if (r > l) { // try a right paren, if there’s a matching left
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);
			}
		}
	}
    */

}
