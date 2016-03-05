package com.ds.sort;

public class BinarySearchString {

	private static int binarySearch(String[] a, String key) {

		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key.equals(a[mid]))
				return mid;
			if (key.compareTo(a[mid]) < 0) {
				hi = mid - 1;
			}

			if (key.compareTo(a[mid]) > 0) {
				lo = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		String[] input = { "a", "b", "c", "d", "e", "f" };
		System.out.println(binarySearch(input, "d"));
	}

}
