package com.ds.sort;

public class BinarySearchStringWithEmptyInputs {

	private static int binarySearch(String[] a, String key) {

		int lo = (a[0].equals("") == true) ? moveIndexRight(a, 0) : 0;
		int hi = (a[a.length - 1].equals("") == true) ? moveIndexLeft(a, a.length - 1) : a.length - 1;

		if (lo == -1 || hi == -1)
			return -1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			mid = (a[mid].equals("") == true) ? moveIndexRight(a, mid) : mid;

			if (key.equals(a[mid]))
				return mid;
			if (key.compareTo(a[mid]) < 0) {
				hi = mid - 1;
				hi = (a[hi].equals("") == true) ? moveIndexLeft(a, hi) : hi;
			} else {
				lo = mid + 1;
				lo = (a[lo].equals("") == true) ? moveIndexRight(a, lo) : lo;
			}

			if (lo == -1 || hi == -1)
				return -1;

		}

		return -1;
	}

	private static int moveIndexRight(String[] a, int currentIndex) {

		int index = -1;

		// assuming current index is blank
		while (currentIndex < a.length && a[currentIndex].equals("")) {
			currentIndex++;
			index = currentIndex;
		}

		return index;
	}

	private static int moveIndexLeft(String[] a, int currentIndex) {

		int index = -1;

		// assuming current index is blank
		while (currentIndex >= 0 && a[currentIndex].equals("")) {
			currentIndex--;
			index = currentIndex;
		}

		return index;
	}

	public static void main(String[] args) {

		// string array is sorted but there might be blanks in them
		String[] input = { "", "", "a", "b", "", "c", "", "d", "", "e", "", "f", "", "", "" };
		System.out.println(binarySearch(input, "f"));
	}

}
