package com.ds.string;


public class StringToInteger {
	public static int myAtoi(String str) {
		boolean negative = false;

		str = str.trim();
		if (str == null || str.length() < 1) {
			return 0;
		}

		if (str.charAt(0) == '-') {
			negative = true;
			str = str.substring(1);
		}

		long result = 0;
		for (int i = 0; i < str.length(); i++) {
			result = (result * 10) + (str.charAt(i) - '0');
		}

		if (result > Integer.MAX_VALUE) {
			return 0;
		}

		if (negative && result * -1 < Integer.MIN_VALUE) {
			return 0;
		}

		return negative == true ? (int) result * -1 : (int) result;
	}

	public static void main(String[] args) {
		System.out.println("123: " + myAtoi("123"));
		System.out.println("-7890: " + myAtoi("-7890"));
		// System.out.println("+abc".substring(1));
	}


}
