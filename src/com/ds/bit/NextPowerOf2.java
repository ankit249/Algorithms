package com.ds.bit;

public class NextPowerOf2 {

	public static int nextPowerOf2(int n) {
		if (n == 0) {
			return 1;
		}
		if (n > 0 && (n & (n - 1)) == 0) {
			return n;
		}
		while ((n & (n - 1)) > 0) {
			n = n & (n - 1);
		}
		return n << 1;
	}

	public static void main(String args[]) {
		System.out.println(nextPowerOf2(6));
	}
}
