package com.ds.basic;

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

	public static void main(String[] args) {
		System.out.println(isPrime(7));

		System.out.println("abc".substring(0, 1));
	}
}
