package com.ds.math;

// 1, 3, 5, 7
public class Square {
	private static int square(int n) {
		int j = 0;
		int sum = 1;
		int result = 0;
		while (j < n) {
			result = result + sum;
			sum = sum + 2;
			j++;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(square(4));
	}
}
