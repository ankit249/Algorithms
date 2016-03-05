package com.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// merging k sorted arrays
public class MergeKSortedArrayPQ {

	public static void main(String[] args) {
		int[] array1 = { 1, 6, 8, 10, 15 };
		int[] array2 = { 2, 7, 9, 11, 16 };
		int[] array3 = { 3, 4, 12, 18, 20 };

		MergeKSortedArrayPQ m = new MergeKSortedArrayPQ();
		int[] result = m.mergeKSortedArray(new int[][] { array1, array2, array3 });
		System.out.println(Arrays.toString(result));
	}

	public class ArrayHolder implements Comparable<ArrayHolder> {
		int[] array;
		int index;

		public ArrayHolder(int[] array, int index) {
			this.array = array;
			this.index = index;
		}

		@Override
		public int compareTo(ArrayHolder o) {
			return this.array[this.index] - o.array[o.index];
		}
	}

	public int[] mergeKSortedArray(int[][] a) {

		PriorityQueue<ArrayHolder> pq = new PriorityQueue<ArrayHolder>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			pq.add(new ArrayHolder(a[i], 0));
			count = count + a[i].length;
		}

		int[] result = new int[count];
		int currentIndex = 0;

		while (!pq.isEmpty()) {
			ArrayHolder tmp = pq.poll();
			result[currentIndex++] = tmp.array[tmp.index++];
			if (tmp.array.length > tmp.index) {
				pq.add(new ArrayHolder(tmp.array, tmp.index));
			}
		}
		return result;
	}
}
