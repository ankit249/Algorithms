package com.ds.string;

import java.util.Scanner;

public class Gemstones {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] str_array = new String[n];
		int result_count = 0;

		int[][] mat = new int[26][n];

		for (int i = 0; i < n; i++) {
			str_array[i] = scanner.next();
			for (char ch : str_array[i].toCharArray()) {

				mat[ch - 'a'][i] = 1;
			}
		}

		for (int row = 0; row < 26; row++) {
			int count = 0;
			for (int column = 0; column < n; column++) {
				count = count + mat[row][column];
			}
			if (count == n)
				result_count++;
		}

		System.out.println(result_count);
	}
}
