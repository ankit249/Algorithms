package com.ds.string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	private static String largestNumber(int[] a) {
		String[] sa = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			sa[i] = a[i] + "";
		}

		// reverse array sorting with two string combination
		Arrays.sort(sa, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String element : sa) {
			sb.append(element);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int[] a = { 3, 30, 34, 5, 9, 0 };
		// int[] a = { 45, 4 };
		// int[] a = { 30, 3 };
		System.out.println(largestNumber(a));
	}
}
