package com.ds.basic;

public class MaximumProduct3Elements {

	public static void main(String[] args) {
		// int[] a = { 0, -1, 3, 100, -70, -5 };
		// int[] a = {1, 3, 5, 2, 8, 0, -1, 3};
		int[] a = { 1, 3, 5, 2, 8, 0, -1, 3 };
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int maxNeg1 = Integer.MAX_VALUE;
		int maxNeg2 = Integer.MAX_VALUE;

		for (int element : a) {
			if (element > 0) {
				if (max1 < element) {
					max3 = max2;
					max2 = max1;
					max1 = element;
				} else if (max2 < element) {
					max3 = max2;
					max2 = element;
				} else if (max3 < element) {
					max3 = element;
				}
			} else {
				if (element < 0) {
					if (maxNeg1 > element) {
						maxNeg2 = maxNeg1;
						maxNeg1 = element;
					} else if (maxNeg2 > element) {
						maxNeg2 = element;
					}
				}
			}
		}

		if (max2 * max3 > maxNeg1 * maxNeg2)
			System.out.println(max1 * max2 * max3);
		else {
			System.out.println(max1 * maxNeg1 * maxNeg2);
		}
	}

}
