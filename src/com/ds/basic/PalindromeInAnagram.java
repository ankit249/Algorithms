package com.ds.basic;

import java.util.Scanner;

public class PalindromeInAnagram {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();

		String ans = "YES";
		int oddcount = 0;
		int[] charArray = new int['z' - 'a' + 1];
		for (int i = 0; i < inputString.length(); i++) {
			charArray[inputString.charAt(i) - 'a']++;
		}

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] % 2 != 0) {
				oddcount++;
			}
		}

		if (oddcount > 1) {
			ans = "NO";
		}

		// Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
		System.out.println(ans);
		myScan.close();

	}
}
