package com.ds.sort;

import java.util.Arrays;
import java.util.List;



public class MergeSort {

	// TC - O(nlogn)  = merge takes o(n) and number of times mergesort gets called recursively is (logn) (best, average and worst is O(nlogn)
	// SC - O(n) - one tmp array
	// stability - Mergesort is more stable than Quicksort (sort by name, age) - when name is same age would kick in for example, first based on
	//               one field and then second based on another field, so when more than one key is involved or sorting objects use Mergesort like Java uses Timesort(hybrid of Mergesort and InsertionSort) for Objects
	//				and TimeSort is stable because both Mergesort and Insertion Sort is stable
	// stable because lets say you have 3a and 3b in two sorted merged halves
	// 1 3a 4 5       2 3b 6 7    since aux[i] <= aux[j]   we use a[k++] = aux[i++]
    //   i              j
	// this is the best version of mergesort since the returned array is original input (so its inplace solution)

	public static void mergeSort(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + ((hi - lo) / 2 );
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);

	}

	// ANSWER EXPLANATION
	/*
    merge two sorted halves 3456 and 1278

    auxilliary array                       main array
    a                                      a

    lo      mid          hi                k
    3  4  5  6  1  2  7  8                 3  4  5  6  1  2  7  8
    i           j

    lo      mid          hi                   k
    3  4  5  6  1  2  7  8                 1  4  5  6  1  2  7  8
    i              j

    lo      mid          hi                      k
    3  4  5  6  1  2  7  8                 1  2  5  6  1  2  7  8
    i                 j

    lo      mid          hi                         k
    3  4  5  6  1  2  7  8                 1  2  3  6  1  2  7  8
       i              j

    lo      mid          hi                            k
    3  4  5  6  1  2  7  8                 1  2  3  4  1  2  7  8
          i           j

    lo      mid          hi                               k
    3  4  5  6  1  2  7  8                 1  2  3  4  5  2  7  8
             i        j

    lo      mid          hi                                  k
    3  4  5  6  1  2  7  8                 1  2  3  4  5  6  7  8    here i > mid
                i     j

    lo      mid          hi                                     k
    3  4  5  6  1  2  7  8                 1  2  3  4  5  6  7  8
                i        j

    lo      mid          hi                                     k
    3  4  5  6  1  2  7  8                 1  2  3  4  5  6  7  8
                i          j


	 */
	public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[i] <= aux[j])
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
	}

	public static void main(String[] args) {

		// mergesort
		int[] a = { 9, 2, 6, 3, 5, 1 };
		int[] aux = new int[a.length];
		mergeSort(a, aux, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

		//mergesort while arraylist is given
		/*
		Integer[] array = { 9, 2, 6, 3, 5, 1 };
		List<Integer> list = Arrays.asList(array);
		System.out.println(list);

		Integer[] a = list.toArray(new Integer[0]);
		Integer[] aux = new Integer[a.length];
		mergeSort(a, aux, 0, a.length - 1);
		System.out.println(Arrays.asList(a));
		*/

		// merge two sorted arrays
		int[] m = { 2, 3, 5, 6, 7 };
		int[] n = { 6, 7, 8, 9, 10 };
		int[] res = merge(m, n);
		System.out.println(Arrays.toString(res));
	}

	// ANSWER EXPLANATION
/*
merge two sorted halves sorted array
2, 3, 5, 6, 7        6, 7, 8, 9, 10        0, 0, 0, 0, 0, 0, 0, 0, 0, 0
i                    j                     k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 0, 0, 0, 0, 0, 0, 0, 0, 0
   i                 j                        k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 3, 0, 0, 0, 0, 0, 0, 0, 0
      i              j                           k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 3, 5, 0, 0, 0, 0, 0, 0, 0
         i           j                              k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 3, 5, 6, 0, 0, 0, 0, 0, 0
            i        j                              k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 3, 5, 6, 6, 0, 0, 0, 0, 0
            i           j                              k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 3, 5, 6, 6, 7, 0, 0, 0, 0      // i < a.length && j < b.length
              i         j                                 k

2, 3, 5, 6, 7        6, 7, 8, 9, 10        2, 3, 5, 6, 6, 7, 7, 8, 9, 10     // j < b.length
              i                     j                                    k


*/

	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];

		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < a.length) {
			c[k++] = a[i++];
		}

		while (j < b.length) {
			c[k++] = b[j++];
		}

		return c;
	}

}