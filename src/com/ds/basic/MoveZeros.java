package com.ds.basic;

import java.util.Arrays;

//Given an array nums, write a function to move all 0's to the end of 
// it while maintaining the relative order of the non-zero elements.

//For example, given a = [0, 1, 0, 3, 12], after calling your function, 
// a should be [1, 3, 12, 0, 0].
public class MoveZeros {

	private static int[] moveZerosToEnd(int[] a) {
		int i = 0;
		int j = 0;

		while (j < a.length) {
			if (a[j] == 0) {
				j++;
			} else {
				a[i] = a[j];
				i++;
				j++;
			}
		}

		while (i < a.length) {
			a[i] = 0;
			i++;
		}

		return a;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 3, 12 };
		System.out.println(Arrays.toString(moveZerosToEnd(a)));
	}

}
