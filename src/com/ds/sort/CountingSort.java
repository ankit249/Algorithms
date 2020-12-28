package com.ds.sort;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	private static void countSort(int[] a, int max) {
		int n = a.length;
		int[] countArray = new int[n];

		for (int i = 0; i < n; i++) {
			countArray[a[i]] = countArray[a[i]] + 1;
		}

		for (int i = 1; i < n; i++) {
			countArray[i] = countArray[i - 1] + countArray[i];
		}

		// inplace solution o(1) space
		int p = 0;
		int indx = 0;
		while (indx < countArray[p] && p < max) {
			a[indx++] = p;
			if (indx == countArray[p]) {
				p = p + 1;
			}
		}
		System.out.println("Output: " + Arrays.toString(a));

		/*
		for (int i = 0; i < n; i++) {
			int index = countArray[arr[i]] - 1;
			countArray[arr[i]] = countArray[arr[i]] - 1;
			sorted[index] = arr[i];
		}

		for (int k = 0; k < sorted.length; k++) {
			System.out.print(sorted[k] + " ");
		}
		*/

	}

	/*

you can use this for upto maximum of 0, 1 or 0, 1 and 2

mid
1,  0,  0,  1,  0,  0,  2,  2,  1,  1
lo                                  hi

lo  mid                             hi
1,  0,  0,  1,  0,  0,  2,  2,  1,  1

    lo  mid                         hi
0,  1,  0,  1,  0,  0,  2,  2,  1,  1

        lo  mid                     hi
0,  0,  1,  1,  0,  0,  2,  2,  1,  1

        lo     mid                  hi
0,  0,  1,  1,  0,  0,  2,  2,  1,  1

            lo      mid             hi
0,  0,  0,  1,  0,  0,  2,  2,  1,  1

				lo      mid         hi
0,  0,  0,  0,  0,  1,  2,  2,  1,  1

				lo      mid     hi
0,  0,  0,  0,  0,  1,  1,  2,  1,  2

                lo          mid hi
0,  0,  0,  0,  0,  1,  1,  2,  1,  2

	            lo          mid
0,  0,  0,  0,  0,  1,  1,  1,  2,  2
                            hi

	            lo              mid
0,  0,  0,  0,  0,  1,  1,  1,  2,  2
                            hi

	 */
	private static void DijkstrasSorting(int[] a) {

		int lo = 0;
		int mid = 0;
		int hi = a.length - 1;

		while(mid <= hi) {
			if(a[mid] == 0) {
				swap(a, lo, mid);
				lo++;
				mid++;
			} else if(a[mid] == 1) {
				mid++;
			} else if(a[mid] == 2) {
				swap(a, mid, hi);
				hi--;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int n = 10;

		Random random = new Random();
		int max = 3;
		int min = 0;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(max - min) + min;
		}

		System.out.println("Array Input: " + Arrays.toString(a));
		countSort(a, max);

		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(max - min) + min;
		}

		System.out.println("Running Dijkstra for input : " + Arrays.toString(a));
		DijkstrasSorting(a);
		System.out.println("Output : " + Arrays.toString(a));
	}
}
