package com.ds.math;

// 1, 3, 5, 7
public class Square {
	private static int square(int n) {
		int i = 0;
		int sum = 1;
		int result = 0;
		while (i < n) {
			result = result + sum;
			sum = sum + 2;
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(square(4));
	}
}
