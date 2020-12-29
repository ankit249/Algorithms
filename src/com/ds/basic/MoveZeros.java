package com.ds.basic;

import java.util.Arrays;

//Given an array nums, write a function to move all 0's to the end of 
// it while maintaining the relative order of the non-zero elements.

//For example, given a = [0, 1, 0, 3, 12], after calling your function, 
// a should be [1, 3, 12, 0, 0].

// ANSWER EXPLANATION
/*
lo
0  1  0  3  12
hi

lo hi
0  1  0  3  12

   lo hi
1  0  0  3  12

   lo	 hi
1  0  0  3  12

      lo    hi
1  3  0  0  12     hi = a.lenth - 1 ( one more swap remaining )

          lo    hi
1  3  12  0  0

 */
public class MoveZeros {

	private static int[] moveZerosToEnd(int[] a) {
		int lo = 0;
		int hi = 0;

		while (hi <= a.length - 1) {
			if(a[hi] != 0) {
				swap(a, lo, hi);
				lo++;
				hi++;
			} else if(a[hi] == 0) {
				hi++;
			}
		}
		return a;
	}

	private static void swap(int[] a, int i, int j) {
		// minimize the swap if its same location or both i and j are even
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 3, 12 };
		System.out.println(Arrays.toString(moveZerosToEnd(a)));
	}

}
