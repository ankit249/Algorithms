package com.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7      3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 Note:
    + create a MaxHeap size of k, add i = 0 to k
    + in each step, extract the max, add i++

 */
public class SlidingWindowMaximum {

	private static int[] maxSlidingWindow(int[] a, int k) {
		if(a == null || a.length == 0) return new int[] {};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int[] result = new int[a.length - k + 1];
		int count = 0;
		for (int i = 0; i < a.length - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				pq.offer(a[j]);
			}
			result[count] = pq.poll();
			count = count + 1;
			pq.clear();
		}
		return result;

	}

	public static void main(String[] args) {
		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(a, k)));
	}
}
