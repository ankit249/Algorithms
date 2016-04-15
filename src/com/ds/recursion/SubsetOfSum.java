package com.ds.recursion;

// bruteforce,         
// time complexity O(2n)   <-- Exponential
public class SubsetOfSum {

	public static void subsetofsum(int start, int[] a, boolean[] barray, int target, int currentsum) {

		if (currentsum == target) {
			System.out.print("Subset (");
			for (int i = 0; i < barray.length; i++) {
				if (barray[i]) {
					System.out.print(a[i] + " ");
				}
			}
			System.out.println(")");
			return;
		}

		if (start >= a.length) {
			return;
		}

		// select the start index in the current sum
		barray[start] = true;
		currentsum = currentsum + a[start];
		subsetofsum(start + 1, a, barray, target, currentsum);

		// don't select the start index in the current sum
		barray[start] = false;
		currentsum = currentsum - a[start];
		subsetofsum(start + 1, a, barray, target, currentsum);

	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 7, 1, 8, 4, 5, 6 };
		int target = 8;
		boolean[] barray = new boolean[a.length];

		subsetofsum(0, a, barray, target, 0);

	}
}
