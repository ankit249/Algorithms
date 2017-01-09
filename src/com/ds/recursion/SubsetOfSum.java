package com.ds.recursion;

// bruteforce,         
// time complexity O(2n)   <-- Exponential
public class SubsetOfSum {

	public static void subsetofsum(int[] a, int index, boolean[] barray, int target) {

		if (target == 0) {
			for (int i = 0; i < barray.length; i++) {
				if (barray[i]) {
					System.out.print(a[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		if (index >= a.length) {
			return;
		}

		// select the start index in the current sum
		barray[index] = true;
		subsetofsum(a, index + 1, barray, target - a[index]);

		// don't select the start index in the current sum
		barray[index] = false;
		subsetofsum(a, index + 1, barray, target);

	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 1, 8, 4, 5, 6 };
		int target = 8;
		boolean[] barray = new boolean[a.length];

		subsetofsum(a, 0, barray, target);

	}
}
