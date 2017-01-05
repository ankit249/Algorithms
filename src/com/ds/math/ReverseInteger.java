package com.ds.math;

public class ReverseInteger {
	public static int reverse(int x) {
		int n = Math.abs(x);
		long result = 0;

		while (n != 0) {
			result = (result * 10) + (n % 10);
			n = n / 10;
		}

		if (x < 0) {
			result = result * -1;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}

		return (int) result;
	}

	public static boolean isPalindrome(int num) {
		if (num < 0)
			return false;
		return num == reverse(num);
	}

	public static void main(String[] args) {
		int number = 2332;
		System.out.println(reverse(number));
		System.out.println(reverse(1534236469));
		System.out.println(isPalindrome(4000));
		System.out.println(isPalindrome(1));

		System.out.println("MAX: " + Integer.MAX_VALUE);
		System.out.println("MIN: " + Integer.MIN_VALUE);
	}
}
