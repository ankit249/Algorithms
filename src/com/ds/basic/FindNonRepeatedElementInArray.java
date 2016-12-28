package com.ds.basic;

public class FindNonRepeatedElementInArray {

	private static int findNonRepeatative(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result = result ^ a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7 };
		int result = findNonRepeatative(a);
		System.out.println(result);
	}

}
