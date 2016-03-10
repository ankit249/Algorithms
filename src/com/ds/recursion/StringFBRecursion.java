package com.ds.recursion;

/*
 given 123
 print 1+2+3, 
       1+2-3,
       1-2+3
       1-2-3
       
       same with -
       
*/
public class StringFBRecursion {

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

	public static void main(String[] args) {
		fn("123");
		System.out.println();
		System.out.println("--------------------");
		fn("1");
	}
}
