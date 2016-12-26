package com.ds.string;

//https://www.youtube.com/watch?v=CE2b_-XfVDk
public class LongestIncreasingSubSequence {

	public static void printLIS(int[] a) {

		String[] paths = new String[a.length];
		int[] sizes = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			sizes[i] = 1;
			paths[i] = a[i] + " ";
		}

		int max = 1;

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && sizes[i] < sizes[j] + 1) {
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + a[i] + " ";
					max = Math.max(max, sizes[i]);
				}
			}
		}

		for (int i = 1; i < a.length; i++) {
			if (sizes[i] == max) {
				System.out.println(paths[i]);
			}
		}

	}

	public static void main(String[] args) {
		int[] a = { 7, 6, 1, 2, 5, 6, 7, -3, 1, 2, 4, 5, 6 };

		printLIS(a);
	}
}
