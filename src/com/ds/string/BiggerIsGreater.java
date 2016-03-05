package com.ds.string;

import java.util.Scanner;

public class BiggerIsGreater {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] input = new String[n];

		for (int i = 0; i < n; i++) {
			input[i] = scanner.next();
		}

		for (int i = 0; i < input.length; i++) {
			System.out.println(bigger_is_greater(input[i]));
		}
	}

	private static String bigger_is_greater(String string) {
		StringBuffer result = new StringBuffer();
		int[] alphabets = new int[26];
		for (char c : string.toCharArray()) {
			alphabets[(int) c - 'a']++;
		}

		for (int i = 25; i >= 0; i--) {
			while (alphabets[i] > 0) {
				char ch = (char) (i + 'a');
				result = result.append(ch);
				alphabets[i]--;
			}
		}

		return string.equalsIgnoreCase(result.toString()) ? "no answer" : result.toString();
	}
}
