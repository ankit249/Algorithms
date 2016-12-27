package com.ds.basic;

import java.util.Arrays;

/*
There are N children standing in a line. Each child is assigned a rating value. You are giving candies to 
these children subjected to the following requirements:
1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

Analysis

This problem can be solved in O(n) time.

We can always assign a neighbor with 1 more if the neighbor has higher a rating value. However, to get the 
minimum total number, we should always start adding 1s in the ascending order. We can solve this problem by scanning 
the array from both sides. First, scan the array from left to right, and assign values for all the ascending pairs. 
Then scan from right to left and assign values to descending pairs. 
 */
public class Candy {

	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] candies = new int[ratings.length];
		candies[0] = 1;

		// from let to right
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				// if not ascending, assign 1
				candies[i] = 1;
			}
		}
		// System.out.println(Arrays.toString(candies));
		int result = candies[ratings.length - 1];

		// from right to left
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = candies[i + 1] + 1;
			}

			result = result + candies[i];
		}

		System.out.println(Arrays.toString(candies));
		return result;
	}

	public static void main(String[] args) {
		int[] ratings = { 1, 4, 3, 3, 3, 1 };
		System.out.println(candy(ratings));
	}
}
