package com.ds.basic;
/**
A peak element is an element that is greater than its neighbors. 
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. 
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞. 
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Thoughts

This is a very simple problem. We can scan the array and find any element that is greater can 
its previous and next. The first and last element are handled separately.
 */
public class FindPeakElement {

	private static int findPeak(int[] a) {
		int max = a[0] > a[1] ? a[0] : Integer.MIN_VALUE;
		int index = 0;

		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
				if (a[i] > max) {
					index = i;
					max = a[i];
				}
			}
		}

		if (a[a.length - 1] > max) {
			index = a.length - 1;
		}

		return index;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1 };
		System.out.println("Peak element index: " + findPeak(a));
	}

}
