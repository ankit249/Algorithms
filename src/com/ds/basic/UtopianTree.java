package com.ds.basic;

import java.util.Scanner;

public class UtopianTree {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int result = 0;
		int t = input.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = input.nextInt();

			// if even
			// Math.pow(2,arr[i] / 2 + 1) - 1
			// if odd
			// Math.pow(2,arr[i] / 2 + 1) - 1 * 2

			result = ((1 << (arr[i] / 2 + 1)) - 1) * 1 << (arr[i] % 2);
			System.out.println(result);
		}


	}
}
