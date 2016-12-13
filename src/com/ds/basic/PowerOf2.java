package com.ds.basic;

public class PowerOf2 {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			System.out.println(1 << i);
		}

		System.out.println(2 << 3);

		System.out.println(isPowerOf2(4));
		System.out.println(isPowerOf2(5));
		System.out.println(isPowerOf2(7));
		System.out.println(isPowerOf2(8));
	}

	// & the number and previous number to see if that is zero
	private static boolean isPowerOf2(int v) {
		// we want to see if v is a power of 2

		return (v & (v - 1)) == 0;
	}
}
