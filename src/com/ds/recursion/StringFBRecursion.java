package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 given 123
 print 1+2+3, 
       1+2-3,
       1-2+3
       1-2-3
       
       same with -
       
*/
public class StringFBRecursion {

	private static List<String> getCombinations(char[] input) {
		List<String> result = new ArrayList<>();
		helper(input, new char[input.length], 0, result);
		return result;
	}

	private static void helper(char[] input, char[] slate, int pos, List<String> result) {
		if(pos >= input.length) {
			if(slate[0] == '+') {
				result.add(new String(slate, 1, slate.length - 1));
			} else {
				result.add(new String(slate));
			}
			return;
		}

		if(input[pos] == '+') {
			slate[pos] = '+';
			helper(input, slate, pos + 1, result);

			slate[pos] = '-';
			helper(input, slate, pos + 1, result);
		} else {
			slate[pos] = input[pos];
			helper(input, slate, pos + 1, result);
		}
	}


	public static void main(String[] args) {
		// IK Approach

		String string = "123";
		/*
		char[] input = new char[2 * string.length()];
		int j = 0;
		for(int i = 0; i < string.length(); i++) {
			input[j++] = '+';
			input[j++] = string.charAt(i);
		}
		//System.out.println(input);
		List<String> result = getCombinations(input);
		System.out.println(result);
		*/

		// IK 2 approach
		string = "123";
		System.out.println(getcombo(string));
		// ORIGINAL APPROACH
		/*
		fn("123");
		System.out.println();
		System.out.println("--------------------");
		fn("1");
		*/
	}

	private static List<String> getcombo(String input) {
 		List<String> slate = new ArrayList<>();
 		var result = new ArrayList<String>();
 		helperCombo(input.toCharArray(), 0, slate, result);
 		return result;
	}

	private static void helperCombo(char[] input, int pos, List<String> slate, List<String> results) {
		if(pos >= input.length) {
			results.add(String.join("",slate));
			return;
		}

		slate.add("+");
		slate.add(String.valueOf(input[pos]));
		helperCombo(input, pos + 1, slate, results);

		slate.remove(slate.size() - 1);
		slate.remove(slate.size() - 1);

		slate.add("-");
		slate.add(String.valueOf(input[pos]));
		helperCombo(input, pos + 1, slate, results);
		slate.remove(slate.size() - 1);
		slate.remove(slate.size() - 1);
	}

	private static void fn(String input) {
		function(input, new StringBuilder());
		return;
	}

	private static void function(String input, StringBuilder sb) {

		if (input == null || input.length() == 0)
			return;

		sb.append(input.charAt(0));

		if (input.substring(1).length() == 0) {
			System.out.println(sb.toString());
			System.out.println("-" + sb.toString());
		} else {
			function(input.substring(1), sb.append("+"));
			function(input.substring(1), sb.append("-"));
		}

		// remove last two characters from stringbuilder
		remove2chars(sb);
	}

	private static void remove2chars(StringBuilder sb) {
		if (sb.toString() != null && sb.toString().length() > 2) {
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
