package com.ds.math;

/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
(assume that the array is non-empty and the majority element always exist in the array.)
***Linear Time Majority Vote Algorithm***
 */
public class MajorityElement {
	public static int findMajority(int[] a) {
		int count = 1;
		int result = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] == result) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				result = a[i];
				count = 1;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 3, 4, 2, 2, 2, 2, 4 };
		System.out.println(findMajority(a));
		System.out.println(findMajority(new int[] { 6, 7, 7, 6, 7, 6, 7 }));
	}
}
