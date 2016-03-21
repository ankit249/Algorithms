package com.ds.recursion;

public class Fibonacci {

	// O(2n) exponential time complexity with O(1) space
	public static int fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n - 1) + fib(n - 2);
	}

	// O(1) space and O(n) time complexity
	public static int fib_iterative(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 0; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.print(fib_iterative(i) + " ");
		}
	}
}
