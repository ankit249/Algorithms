package com.ds.basic;

//Java program to find maximum product subarray

public class MaximumProductSubArrayElements {

	public static int maxProduct(int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int maxLocal = a[0];
		int minLocal = a[0];
		int global = a[0];

		for (int i = 1; i < a.length; i++) {
			int temp = maxLocal;
			maxLocal = Math.max(Math.max(a[i] * maxLocal, a[i]), a[i] * minLocal);
			minLocal = Math.min(Math.min(a[i] * temp, a[i]), a[i] * minLocal);
			global = Math.max(global, maxLocal);
		}
		return global;
	}

	public static void main(String[] args) {

		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println("Maximum Sub array product is " + maxProduct(arr));
	}
}
