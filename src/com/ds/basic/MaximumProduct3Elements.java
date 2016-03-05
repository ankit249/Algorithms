package com.ds.basic;

public class MaximumProduct3Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = { 0, -1, 3, 100, -70, -5 };// {1, 3, 5, 2, 8, 0, -1, 3};
		int[] a = { 1, 3, 5, 2, 8, 0, -1, 3 };
		int largestPos = 0, maxPos1 = 0, maxPos2 = 0, maxNeg1 = 0, maxNeg2 = 0;

		for (int element : a) {
			if (element > 0) {
				if (largestPos < element) {
					if (largestPos != 0) {
						if (maxPos1 != 0) {
							maxPos2 = maxPos1;
						}
						maxPos1 = largestPos;
					}
					largestPos = element;
				} else {
					if (maxPos1 < element) {
						if (maxPos1 != 0)
							maxPos2 = maxPos1;
						maxPos1 = element;
					} else {
						if (maxPos2 < element) {
							maxPos2 = element;
						}
					}
				}
			} else {
				if (element < 0) {
					if (maxNeg1 > element) {
						if (maxNeg1 != 0)
							maxNeg2 = maxNeg1;
						maxNeg1 = element;
					} else {
						if (maxNeg2 > element) {
							maxNeg2 = element;
						}
					}
				}
			}
		}

		if (maxPos1 * maxPos2 > maxNeg1 * maxNeg2)
			System.out.println(maxPos1 * maxPos2 * largestPos);
		else {
			System.out.println(maxNeg1 * maxNeg2 * largestPos);
		}
	}

}
