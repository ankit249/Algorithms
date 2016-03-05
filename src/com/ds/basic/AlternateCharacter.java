package com.ds.basic;

import java.util.Scanner;

public class AlternateCharacter {

	private static void findAlternateDelete(String[] strArray) {
		for (int i = 0; i < strArray.length; i++) {
			String string = strArray[i];
			int deleteCount = 0;
			int prev = 0;
			int next = prev + 1;
			while (next < string.length()) {
				if (string.charAt(prev) == string.charAt(next)) {
					deleteCount++;
				}
				prev++;
				next++;
			}
			System.out.println(deleteCount);
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		String[] strArray = new String[t];
		for (int i = 0; i < t; i++) {
			strArray[i] = input.next();
		}

		findAlternateDelete(strArray);
	}
}
