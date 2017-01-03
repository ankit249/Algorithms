package com.ds.math;

public class Exponential {

	public static int pow(int x, int n) {
		if (x == 0 || n == 0)
			return 1;
		if (n > 0)
			return (x * pow(x, n - 1));
		else
			return (1 / x * pow(x, n + 1));

	}

	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			System.out.print(pow(2, i) + " ");
		}

		System.out.println("");
		System.out.println("Double solution");

		System.out.println(dpow(2, 3));
	}

	static double dpow(double x, int n) {
		if (n == 0)
			return 1;
		double half = dpow(x, n / 2);

		if (n % 2 == 0)
			return half * half;
		else if (n > 0)
			return half * half * x;
		else
			return half * half / x;
	}
}
