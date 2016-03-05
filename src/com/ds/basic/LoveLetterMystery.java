package com.ds.basic;

import java.util.Scanner;

public class LoveLetterMystery {

	public static void findDecrementCount(String string) {
		int count = 0;
		int n = string.length();
		for (int i = 0; i < n / 2; i++) {
			if (string.charAt(i) != string.charAt(n - i - 1)) {
				count = count + (Math.abs(string.charAt(i) - string.charAt(n - i - 1)));
			}

		}

		System.out.println(count);
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		String[] strArray = new String[t];
		for (int i = 0; i < t; i++) {
			strArray[i] = input.next();
		}

		for (int i = 0; i < strArray.length; i++) {
			String string = strArray[i];
			findDecrementCount(string);
		}

	}
}
