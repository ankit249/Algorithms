package com.ds.math;

//https://www.youtube.com/watch?v=rcYVHczZ9uI
public class TrailingZerosInFactorial {

	private static int trailingZeros(int n) {
		if (n < 0) return 0;
		int count = 0;
		for (int i = 5; n / i >= 1; i = i * 5) {
			count = count + n / i;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(trailingZeros(11));
		System.out.println(trailingZeros(57));
		System.out.println(trailingZeros(387));
	}

}
