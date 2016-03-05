package com.ds.string;

import java.util.Scanner;

public class MakeAnagram {

	public static void main(String[] args) {
		String string = "abcdefghijklmnopqrstuvwxyz";
		int result_count = 0;

		Scanner scanner = new Scanner(System.in);
		String string_one = scanner.next();
		String string_two = scanner.next();

		int[] count_one = new int[string.length()];
		int[] count_two = new int[string.length()];

		for (int i = 0; i < string_one.length(); i++) {
			count_one[string_one.charAt(i) - 'a']++;
		}

		for (int i = 0; i < string_two.length(); i++) {
			count_one[string_two.charAt(i) - 'a']--;
		}

		for (int i = 0; i < string.length(); i++) {
			System.out.println(count_one[string.charAt(i) - 'a']);
		}

		/*
		 * 
		 * for (int i = 0; i < string_two.length(); i++) { count_two[string_two.charAt(i) - 'a']++; }
		 * 
		 * for (int i = 0; i < string.length(); i++) { if (count_one[string.charAt(i) - 'a'] !=
		 * count_two[string.charAt(i) - 'a']) { result_count = result_count + Math.abs(count_one[string.charAt(i) - 'a']
		 * - count_two[string.charAt(i) - 'a']); } }
		 */

		System.out.println(result_count);

	}

	// another way
	private static long del(char[] a, char[] b) {
		int[] A = new int[26];
		int[] B = new int[26];
		for (char t : a)
			A[(int) t - 97]++;
		for (char t : b)
			B[(int) t - 97]++;
		long count = 0;
		for (int i = 0; i < A.length; i++) {
			count += Math.abs(A[i] - B[i]);
		}
		return count;
	}

}
