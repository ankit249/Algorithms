package com.ds.bit;

public class NumbertoBit {
	public static boolean getBit(int num, int i) {
		int result = num & (1 << i);

		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(getBit(3, 1));
	}
}
