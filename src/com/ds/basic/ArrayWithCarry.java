package com.ds.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array and a number, add it in such a way where array is [0,0,1] and number is 4 output will be [0,0,5]
 * Example 2 : array is [1] and number is 9 output will be [1,0]
 */
public class ArrayWithCarry {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 3); // [1, 2, 3]
		List<Integer> l2 = Arrays.asList(9, 2, 9); // [9, 2, 9]

		List<Integer> result = new ArrayList<Integer>();
		
		int maxLength = Math.max(l1.size(), l2.size());
		int carry = 0;
		for (int i = maxLength - 1; i >= 0; i--) {
			if (l1.get(i) != null) {
				carry = carry + l1.get(i);
			}

			if (l2.get(i) != null) {
				carry = carry + l2.get(i);
			}

			result.add(carry % 10);
			carry = carry / 10;
		}

		if (carry > 0) {
			result.add(carry);
		}
		Collections.reverse(result);

		System.out.println(result);
	}
}
