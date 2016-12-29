package com.ds.basic;

import java.util.Arrays;

//https://en.wikipedia.org/wiki/H-index
// I dont get it...
public class H_Index {
	public static int hIndex(int[] citations) {
		Arrays.sort(citations);
		System.out.println(Arrays.toString(citations));

		int result = 0;
		for (int i = 0; i < citations.length; i++) {
			int smaller = Math.min(citations[i], citations.length - i);
			result = Math.max(result, smaller);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 3, 0, 6, 1, 5 };
		System.out.println(hIndex(a));

		int[] b = { 4, 0, 8, 10, 16, 15 };
		System.out.println(hIndex(b));
		
		int[] c = { 11, 14, 4, 2, 24 };
		System.out.println(hIndex(c));
	}
}
