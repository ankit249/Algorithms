package com.ds.bit;

public class Parity {
	static int parity(int x) {
		return (x == 0) ? 0 : parity(x >>> 1) + (x & 0x1);
	}

	public static void main(String[] args) {
		System.out.println(parity(5));
		System.out.println(parity(6));
		System.out.println(parity(16));
	}
}
