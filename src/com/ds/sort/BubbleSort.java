package com.ds.sort;

import java.util.Arrays;

public class BubbleSort {

/*

 i -->
15, 3, 9, 4, 8, 2, 14  number 2 will be bubbled up in the front
                <--j

 i
15, 3, 9, 4, 8, 2, 14

                   j
 i
15, 3, 9, 4, 2, 8, 14
                j

 i
15, 3, 9, 2, 4, 8, 14
             j

 i
15, 3, 2, 9, 4, 8, 14
          j


 i
15, 2, 3, 9, 4, 8, 14
       j

i
2, 15, 3, 9, 4, 8, 14
    j


    i
2, 15, 3, 9, 4, 8, 14
                    j


*/

	private static void bubblesort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = a.length -1 ; j > i; j--) {
				if (a[j] < a[j - 1]) {
					swap(a, j, j -1);
				}
			}
		}
	}

	public static void swap(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}


	public static void main(String[] args) {
		int[] a = new int[] { 15, 3, 9, 4, 8, 2, 14 };
		System.out.println(Arrays.toString(a));
		bubblesort(a);
		System.out.println(Arrays.toString(a));
	}
}
