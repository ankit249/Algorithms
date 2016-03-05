package com.ds.bit;

// Binary represntation of negative 2 base.
public class NegaBinary {

	private static String toNegativeTwoBaseBinary(int number) {
		String s = "";
		while (number != 0) {
			int r = number % -2;
			number = number / -2;
			if (r < 0) {
				r = r + 2;
				number = number + 1;
			}
			s = r + s;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(toNegativeTwoBaseBinary(-15));
	}
}
