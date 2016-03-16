package com.ds.sort;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		insertionSort(array);
		scanner.close();
	}

	private static void insertionSort(int[] a) {

		int swap_count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
					swap_count++;
				}
			}
		}
		printArray(a);

		System.out.println(swap_count);
	}

	private static void printArray(int[] array) {
		for (int n : array) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
