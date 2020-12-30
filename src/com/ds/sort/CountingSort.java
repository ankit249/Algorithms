package com.ds.sort;

import java.util.Arrays;
import java.util.Random;

/*
TC - O(n)
SC - O(n)
stable - yes
*/
public class CountingSort {

	private static void countSort(int[] a, int max) {
		int[] count = new int[10];
		int[] output = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] = count[i] + count[i - 1];
		}

		// i came up with this commented and it works for finite set of inputs
		/*
		int p = 0;
		for (int i = 0; i < a.length; i++) {
			if(count[p] > 0) {
				output[i] = p;
				if(count[p] == i + 1) {
					p = p + 1;
				}
			}
		}

       */

		// this is general block of code and it works for any input
		// Build the output array
		for (int i = a.length - 1; i >= 0; i--) {
			output[count[a[i] % 10] - 1] = a[i];
			count[a[i] % 10]--;
		}

		System.out.println("Output: " + Arrays.toString(output));
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
