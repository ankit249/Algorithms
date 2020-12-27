package com.ds.sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time COMPLEXITY is linear here with QuickSelect O(n)
 *
 * Quick select is better for fixed array size
 * for Streaming input -- minHEAP is better solution
 */
public class kthLargest {


	public static int getKthLargest(int[] a, int K, int lo, int hi) {
		int N = a.length;
		if (K > N) return -1; // edge case

		int kthIndex = N - K; // kth largest index
		// (because 1st largest N - 1, 2nd Largest is N -2 ... N - K)


		// int kthIndex = K - 1; // kth smallest index
		return QuickSelect(a, kthIndex, 0, N - 1);
	}

	public static int QuickSelect(int[] a, int k, int lo, int hi) {
		if (hi <= lo)
			return a[lo];

		int j = partition(a, lo, hi);
		if(j == k) return a[j];
		if(k < j) {
			return QuickSelect(a, k, lo, j - 1);
		} else {
			return QuickSelect(a, k, j + 1, hi);
		}
	}

	public static int partition(int[] a, int lo, int hi) {

		// lo = pickpivot(a);

		// lo is the pivot pointer and hence a[lo] is the pivot element
		int i = lo + 1;
		int j = hi;

		// repeat until i and j pointer cross (i <= j works, equal to is needed)
		while (i <= j) {

			// increase i until a[i] < a[lo] and if its decreasing sorted want to make sure i doesn't go above hi.
			while (a[i] < a[lo] && i < hi) {
				i++;
			}

			// decrease j until a[j] > a[lo]
			while (a[j] > a[lo] && j > lo) {
				j--;
			}

			// exchange a[i] and a[j] if i and j not crossed
			if (i < j) {
				swap(a, i, j);
			}
		}

		// exchange a[lo] with a[j],
		// now a[lo] the pivot is in its proper position
		swap(a, j, lo);

		return j;
	}

	public static void swap(int[] a, int n1, int n2) {
		int tmp = a[n1];
		a[n1] = a[n2];
		a[n2] = tmp;
	}

	public static void main(String[] args) {
		// best solution, linear time
		// find k largest numbers also the same solution (everything to the right of k is all k largets)

		int[] a = { 50, 20, 6, 56, 61, 91 };
		System.out.println(getKthLargest(a, 3, 0, a.length - 1));

		// 6, 20, 50, 56, 61, 91
		// this nlogn
		System.out.println(getKthUsingHeap(a, 3));
	}

	// kth largest in a constant stream of incoming numbers, (keep a heap size is k, new incoming number that is coming in will be ignored)
	// kth largest in a stream can use minHEAP
	public static int getKthUsingHeap(int[] a, int k) {
		Queue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < a.length; i++) {
			q.offer(a[i]);

			if (q.size() > k)
				q.poll();
		}
		return q.peek();
	}

}
