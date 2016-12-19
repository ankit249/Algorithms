package com.ds.sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class kthLargest {
	public static int getKth(int[] a, int k, int lo, int hi) {
		int i = lo + 1;
		int j = hi;

		while (i < j) {

			// condition is different than the Quicksort.
			while (a[lo] <= a[i] && i < hi) {
				i++;
			}

			while (a[lo] > a[j] && j > lo) {
				j--;
			}

			if (i <= j) {
				swap(a, i, j);
			}
		}

		swap(a, lo, j);

		if (j == k - 1) {
			return a[j];
		} else if (j < k - 1) {
			return getKth(a, k, j + 1, hi);
		} else {
			return getKth(a, k, lo, j - 1);
		}
	}

	public static void swap(int[] a, int n1, int n2) {
		int tmp = a[n1];
		a[n1] = a[n2];
		a[n2] = tmp;
	}

	public static void main(String[] args) {
		int[] a = { 50, 20, 6, 56, 61, 91 };
		System.out.println(getKth(a, 3, 0, a.length - 1));

		// 6, 20, 50, 56, 61, 91
		System.out.println(getKthUsingHeap(a, 3));
	}

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
