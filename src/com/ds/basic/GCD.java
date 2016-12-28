package com.ds.basic;

public class GCD {

	public static int gcd(int p, int q) {
		if (p == 0 || q == 0)
			return p + q; // base case
		return gcd(q, p % q);
	}


	public static void main(String[] args) {
		System.out.println(gcd(4, 2));

		System.out.println("3 % 4 = " + 3 % 4);
		System.out.println("4 % 3 = " + 4 % 3);
	}

}
