package com.ds.string;

public class BinaryAddition {
	private static String binaryAddition(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;

		StringBuilder result = new StringBuilder();
		int carry = 0;
		int sum = 0;

		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0) {
				sum = sum + (a.charAt(i) - '0');
				i--;
			}

			if (j >= 0) {
				sum = sum + (b.charAt(j) - '0');
				j--;
			}

			if (sum == 1) {
				result.append("1");
				carry = 0;
			} else if (sum == 2) {
				result.append("0");
				carry = 1;
			} else if (sum == 3) {
				result.append("1");
				carry = 1;
			} else {
				result.append("0");
				carry = 0;
			}
		}

		if (carry == 1) {
			result.append("1");
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "111";
		String b = "101";

		System.out.println("binary addition: " + binaryAddition(a, b));
	}
}
