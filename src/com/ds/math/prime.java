package com.ds.math;

public class prime {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	// A faster method would be to skip all even numbers and only try up to the square root of the number.
	// 2 is a prime number
	public static boolean isPrimeEfficient(int num) {
		if (num < 2) return false;
		if (num == 2) return true;
		
		if (num % 2 == 0) {
			// System.out.println(num + " is not prime");
			return false;
		}
		// int top = (int) Math.sqrt(num) + 1;
		// for (int i = 3; i < top; i += 2) {
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) {
				// System.out.println(num + " is not prime");
				return false;
			}
		}
		// System.out.println(num + " is prime");
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrime(7));
		System.out.println(isPrimeEfficient(7));
		System.out.println(isPrimeEfficient(3));
		System.out.println(isPrimeEfficient(2));
		System.out.println(isPrimeEfficient(1));

	}
}
