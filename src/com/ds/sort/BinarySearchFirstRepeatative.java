package com.ds.sort;

public class BinarySearchFirstRepeatative {
	static int GetLastPosition(int a[], int lo, int hi, int key) {
		int mid;

		while (hi - lo > 1) {
			mid = lo + (hi - lo) / 2;


			if (a[mid] <= key)
				lo = mid;
			else
				hi = mid;
		}

		return lo;
	}

	static int GetFirstPosition(int a[], int lo, int hi, int key) {
		int mid;

		while (hi - lo > 1) {
			mid = lo + (hi - lo) / 2;

			if (a[mid] >= key)
				hi = mid;
			else
				lo = mid;
		}

		return hi;
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 6, 6, 7, 8 };
		System.out.println(GetLastPosition(a, 0, a.length - 1, 6));
		System.out.println(GetFirstPosition(a, 0, a.length - 1, 6));
	}
}
