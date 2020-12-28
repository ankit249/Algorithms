package com.ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

/*
    i -->
15, 3, 9, 4, 8, 2, 14
 <--j

    i
3, 15, 9, 4, 8, 2, 14
j

       i
3, 15, 9, 4, 8, 2, 14
       j

       i
3, 9, 15, 4, 8, 2, 14
   j

       i
3, 9, 15, 4, 8, 2, 14
j

          i
3, 9, 15, 4, 8, 2, 14
          j

          i
3, 9, 4, 15, 8, 2, 14
      j

          i
3, 4, 9, 15, 8, 2, 14
   j

          i
3, 4, 9, 15, 8, 2, 14
j


*/

	private static void insertionSort(int[] a) {

		int swap_count = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j -1);
					swap_count++;
				}
			}
		}
		System.out.println(swap_count);
	}

	public static void swap(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}


	public static void main(String[] args) {
		int[] a = new int[] { 15, 3, 9, 4, 8, 2, 14 };
		System.out.println(Arrays.toString(a));
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
}
