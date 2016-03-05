package com.ds.string;

import java.util.Scanner;

public class FunnyString {

	private static String reverse(String string) {
		if (string.length() < 2) {
			return string;
		}

		return reverse(string.substring(1)) + string.charAt(0);
	}

	/*
	 * public static void main(String[] args) { Scanner scanner = new Scanner(System.in); int n = scanner.nextInt();
	 * String[] strArray = new String[n]; String[] revArray = new String[n]; String[] result = new String[n];
	 * 
	 * for (int i = 0; i < n; i++) { strArray[i] = scanner.next(); revArray[i] = reverse(strArray[i]); }
	 * 
	 * for (int i = 0; i < n; i++) { for (int j = 1; j < strArray[i].length(); j++) { result[i] =
	 * (Math.abs(strArray[i].charAt(j) - strArray[i].charAt(j - 1)) == Math.abs(revArray[i] .charAt(j) -
	 * revArray[i].charAt(j - 1)) ? "Funny" : "Not Funny"); if (result[i] == "Not Funny") { break; } }
	 * 
	 * System.out.println(result[i]); } }
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			String s = in.next();
			int n = s.length();
			boolean funny = true;
			for (int i = 1; i < n; i++) {
				if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != 
					Math.abs(s.charAt(n - i - 1) - s.charAt(n - (i - 1) - 1))) {
					funny = false;
					break;
				}
			}
			if (funny)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
		}
	}
}
