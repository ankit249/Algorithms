package com.ds.basic;

public class FindMaxTwoNumbers {
	public static void main(String[] args) {
		int[] a = { 6, 5, 7, 3 };
		int max_one = 0;
		int max_two = 0;

		for (int i = 0; i < a.length; i++) {
			if (max_one < a[i]) {
				max_two = max_one;
				max_one = a[i];
			} else if (max_two < a[i]) {
				max_two = a[i];
			}
		}

		System.out.println("max: " + max_one + "; second max: " + max_two);
	}
}
