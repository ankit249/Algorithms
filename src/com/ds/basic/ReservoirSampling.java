package com.ds.basic;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {

	// using reservoir sampling select k items
	public static int[] selectRandomKItemsFromNElement(int[] a, int n, int k) {
		int i;
		int[] reservoir = new int[k];
		for (i = 0; i < k; i++) {
			reservoir[i] = a[i];
		}

		while (i < n) {
			// generate a random number j from 0 to i
			int j = randInt(0, i);

			// if random index is smaller than k than swap
			if (j < k) {
				reservoir[j] = a[i];
			}
			i++;
		}

		return reservoir;
	}

	/**
	 * Returns a psuedo-random number between min and max, inclusive. The
	 * <code>Integer.MAX_VALUE - 1</code>.
	 * 
	 */
	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static int randSelect(int numberOne, int numberTwo) {
		Random random = new Random();
		return (random.nextInt(2) % 2) == 0 ? numberOne : numberTwo;
	}

	/**
	 * Given an array of integers. We have to find the max element of the array,
	 * which is at multiple places in the array and return any one of the
	 * indices randomly.
	 */
	public static int findMaxElementIndiceRandom(int[] a) {

		int maxIndice = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > a[maxIndice]) {
				maxIndice = i;
			} else if (a[i] == a[maxIndice]) {
				maxIndice = randSelect(maxIndice, i);
			}
		}

		return maxIndice;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 6, 3, 9, 8, 9, 4, 3, 2, 9, 1, 6 };

		int[] randomSample = selectRandomKItemsFromNElement(a, a.length, 3);
		System.out.println(Arrays.toString(randomSample));

		System.out.println(findMaxElementIndiceRandom(a));

	}
}
