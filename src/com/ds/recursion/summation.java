package com.ds.recursion;

public class summation {

	public static int sum(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		return n + sum(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(sum(5));
	}
}
