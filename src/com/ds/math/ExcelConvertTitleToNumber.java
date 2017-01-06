package com.ds.math;

public class ExcelConvertTitleToNumber {

	private static int toNumber(String string) {
		double result = 0;
		int p = 0;

		for (int i = string.length() - 1; i > -1; i--) {
			result = result * Math.pow(26, p) + (string.charAt(i) - 'A' + 1);
			p++;
		}

		return (int) result;
	}

	public static void main(String[] args) {

		System.out.println(toNumber("A"));
		System.out.println(toNumber("Z"));
		System.out.println(toNumber("AB"));
		System.out.println(toNumber("Y"));
		System.out.println(toNumber("AAA"));
	}

}
