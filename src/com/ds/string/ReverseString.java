package com.ds.string;

public class ReverseString {

	// reverse for loop
	private static String reverse_1(String string) {
		if (string == null) return null;

		StringBuilder sb = new StringBuilder();
		for (int i = string.length() - 1; i >= 0; i--) {
			sb = sb.append(string.charAt(i));
		}
		return sb.toString();
	}

	// using temp variable
	private static String reverse_2(String string) {
		if (string == null) return null;

		int n = string.length();
		char[] ch = string.toCharArray();
		for (int i = 0; i < n / 2; i++) {
			char tmp = ch[i];
			ch[i] = ch[n - 1 - i];
			ch[n - 1 - i] = tmp;
		}

		return String.valueOf(ch);
	}
	
	// using xor
	private static String reverse_3(String string) {
		if (string == null) return null;
		
		char[] ch = string.toCharArray();
		int n = ch.length;
		for (int i = 0; i < n / 2; i++) {
			ch[i] ^= ch[n - i - 1];
			ch[n - 1 - i] ^= ch[i];
			ch[i] ^= ch[n - i - 1];
		}

		return String.valueOf(ch);
	}

	private static String recursiveReverse(String string) {
		if (string == null || string.length() <= 1) {
			return string;
		}
		return recursiveReverse(string.substring(1)) + string.charAt(0);
	}

	// built in java
	public static String reverseWithStringBuilderBuiltinMethod(String string) {
		if(string == null) return null;
		StringBuilder builder = new StringBuilder(string);
		return builder.reverse().toString();
	}

	public static void main(String[] args) {

		System.out.println(reverseWithStringBuilderBuiltinMethod("Ankit"));
		System.out.println(reverseWithStringBuilderBuiltinMethod(null));

		System.out.println(reverse_1("Ankit"));
		System.out.println(reverse_1(null));

		System.out.println(reverse_2("Ankit"));
		System.out.println(reverse_2(null));

		System.out.println(reverse_3("Ankit"));
		System.out.println(reverse_3(null));

		System.out.println(recursiveReverse("Ankit"));
		System.out.println(recursiveReverse(null));

	}

}
