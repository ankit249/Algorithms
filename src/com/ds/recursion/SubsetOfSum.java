package com.ds.recursion;

// bruteforce,         
// time complexity O(2n)   <-- Exponential
public class SubsetOfSum {

	public static void subsetofsum(int[] a, int index, boolean[] barray, int target, int currentsum) {

		if (currentsum == target) {
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
		currentsum = currentsum + a[index];
		subsetofsum(a, index + 1, barray, target, currentsum);

		// don't select the start index in the current sum
		barray[index] = false;
		currentsum = currentsum - a[index];
		subsetofsum(a, index + 1, barray, target, currentsum);

	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 1, 8, 4, 5, 6 };
		int target = 8;
		boolean[] barray = new boolean[a.length];

		subsetofsum(a, 0, barray, target, 0);

	}
}
