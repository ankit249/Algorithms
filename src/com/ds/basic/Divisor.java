package com.ds.basic;

public class Divisor {
	private static void printDivisors(int n) {
		System.out.println("1*" + n);
		printDivisors("", 1, n);
	}

	private static void printDivisors(String prefix, int last, int n) {
		if (n < 2)
			return;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				if (i >= last && n / i >= i) {
					System.out.println(prefix + i + "*" + n / i);
					printDivisors(prefix + i + "*", i, n / i);
				}
			}

		}
	}

	public static void main(String[] args) {
		printDivisors(12);
	}

}
