package com.ds.basic;

public class GCD {

	public static int gcd(int p, int q) {
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}


	public static void main(String[] args) {
		System.out.println(gcd(15, 27));
		System.out.println(gcd(3, 4));
		System.out.println(gcd(144, 224));

		System.out.println("3 % 4 = " + 3 % 4);
		System.out.println("4 % 3 = " + 4 % 3);
	}

}
