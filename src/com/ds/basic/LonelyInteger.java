package com.ds.basic;

import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());
		int[] a = new int[N];
		String line = input.nextLine();
		String[] string = line.split(" ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(string[i]);
		}

		int result = findLonelyIntegerXOR(a);
		System.out.println(result);
	}

	/*
	private static int findLonelyInteger(int[] a) {
		Arrays.sort(a);
		int previous = 0;
		int next = 1;
		int result;

		result = a[previous];

		while (previous < a.length && next < a.length) {
			if (a[previous] == a[next]) {
				previous = previous + 2;
				next = next + 2;
				result = a[previous];
			} else {
				break;
			}

		}

		return result;
	}
	*/

	private static int findLonelyIntegerXOR(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result = result ^ a[i];
		}
		return result;
	}
}
