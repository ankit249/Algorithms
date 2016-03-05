package com.ds.basic;

import java.util.Arrays;

public class PairWiseSum {
	public static int[] reconstruct(int[] p, int n) {
		int[] s = new int[n];
		s[0] = (p[0] + p[1] - p[n - 1]) / 2;
		for (int i = 0; i < n - 1; i++) {
			s[i + 1] = p[i] - s[0];
		}
		return s;
	}

	private static int findN(int x) {

		// n2 - n - 12 = 0 (if x is 6)
		// (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a

		int a = 1;
		int b = -1;
		int c = -(x * 2);

		double result = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;

		return (int) result;

	}

	public static void main(String[] args) {
		int[] p = { 6, 11, 101, 15, 105, 110 };

		int n = findN(p.length);
		System.out.println(n);

		System.out.println(Arrays.toString(reconstruct(p, n)));
	}
}
