package com.ds.bit;

public class Bits {

	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1�s */

		// 1�s through position j, then 0�s
		int left = max - ((1 << j) - 1);

		// 1�s after position i
		int right = ((1 << i) - 1);

		// 1�s, with 0s between i and j
		int mask = left | right;

		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}

	public static void main(String[] args) {
		int n = 32768;
		int m = 21;
		int i = 2;
		int j = 6;

		System.out.println(updateBits(n, m, i, j));

		System.out.println(3 << 1);
		System.out.println(1 << 4);
		System.out.println(3 >> 1);
	}

}