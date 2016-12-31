package com.ds.recursion;

// https://www.mathsisfun.com/numbers/fibonacci-sequence.html
// 0, 1, 2, 3, 4, 5, 6
// 0, 1, 1, 2, 3, 5, 8
public class Fibonacci {

	// O(2^n) exponential time complexity with O(1) space
	public static int fib(int n) {
		if (n == 0) return 0;
		if (n == 1 || n == 2) return 1;
		return fib(n - 1) + fib(n - 2);
	}

	// O(1) space and O(n) time complexity
	public static int fib_iterative(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 0; i < n; i++) {
			a = b;
			b = c;
			c = a + b;
		}
		return c;
	}

	// tail recursion, O(1) space and O(n) time complexity
	public static int tailRecursive(int n) {
		if(n == 0) return 0;
		return fibtail(n, 0, 1);
	}

	private static int fibtail(int n, int a, int b) {
		if (n == 0) return a;
		return fibtail(n - 1, b, a + b);
	}

	public static void main(String[] args) {
		System.out.println("Using Iterative....");
		for (int i = 0; i <= 6; i++) {
			System.out.print(fib_iterative(i) + " ");
		}

		// Tail recursion
		System.out.println();
		System.out.println("Using Tail Recursion....");
		for (int i = 0; i <= 6; i++) {
			System.out.print(tailRecursive(i) + " ");
		}

	}

}
