package com.ds.basic;

import java.util.Arrays;
import java.util.Random;

/**
 * Given array A of size N, using function Random(returns random number between 0 and 1) implement function that will
 * return array of size N with randomly shuffled elements of the array A. You shoul give only algo.
 */

public class RandomShuffle {

	
	/**
	 * random no from: 0 to 9 ---> swap a[0] with random
	 * random no from: 1 to 9 ---> swap a[1] with random
	 * random no from: 2 to 9 ---> swap a[2] with random
	 * random no from: 3 to 9 ---> swap a[3] with random
	 * random no from: 4 to 9 ---> swap a[4] with random
	 * ...
	 * ...
	 * 
	 */
	public static void shuffle(int[] a) {
		Random r = new Random();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int random = r.nextInt(n - i);
			int tmp = a[random];
			a[random] = a[i];
			a[i] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] a = { 6, 9, 2, 12, 34, 56, 43, 22 };
		System.out.println("original array: " + Arrays.toString(a));

		for (int i = 0; i < 20; i++) {
			shuffle(a);

			System.out.println("shuffled array: " + Arrays.toString(a));
		}
	}
}
