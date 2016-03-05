package com.ds.basic;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, 5);
		// int p = 0345;
		// System.out.println(p);
		System.out.println(Arrays.toString(b));

		Integer[] a1 = { 1 - 5 };
		for (int ele : a1) {
			System.out.println(ele);
		}
		
	}
}
