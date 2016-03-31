package com.ds.basic;

import java.util.Arrays;
import java.util.Random;

/**
 * Given array A of size N, using function Random(returns random number between 0 and 1) implement function that will
 * return array of size N with randomly shuffled elements of the array A. You shoul give only algo.
 */

public class RandomShuffle {

	
	/**
	 * random no from: 5 to 0 ---> swap a[5] with random
	 * random no from: 4 to 0 ---> swap a[4] with random
	 * random no from: 3 to 0 ---> swap a[3] with random
	 * random no from: 2 to 0 ---> swap a[2] with random
	 * random no from: 1 to 0 ---> swap a[1] with random
	 * ...
	 * ...
	 * 
	 */
	public static void shuffle(int[] a) {
		Random r = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			int random = r.nextInt(i);
			swap(a, i, random);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = { 6, 9, 2, 12, 34, 56, 43, 22 };
		
		// JDK shuffle method
		// Collections.shuffle(Arrays.asList(a));
		System.out.println("original array: " + Arrays.toString(a));

		for (int i = 0; i < 20; i++) {
			shuffle(a);

			System.out.println("shuffled array: " + Arrays.toString(a));
		}
	}
}
