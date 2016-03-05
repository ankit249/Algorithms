package com.ds.basic;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = Integer.parseInt(scanner.nextLine());
		char[][] a = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				a[i][j] = line.charAt(j);
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
					System.out.print(a[i][j]);
					continue;
				}
				int depth = a[i][j];
				if (depth > a[i - 1][j] && depth > a[i + 1][j] && depth > a[i][j - 1] && depth > a[i][j + 1]) {
					a[i][j] = 'X';
				}
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
	}
}