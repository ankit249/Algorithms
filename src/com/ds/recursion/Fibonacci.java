package com.ds.recursion;

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
		if(n == 1 || n == 2) return 1;
		return fibtail(0, 1, n);
	}

	private static int fibtail(int a, int b, int n) {
		if (n <= 0) {
			return a;
		}
		return fibtail(b, a + b, n - 1);
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			System.out.print(fib_iterative(i) + " ");
		}

		// Tail recursion
		System.out.println();
		System.out.println("Using Tail Recursion....");
		System.out.println(tailRecursive(5));

	}

}
