package com.ds.sort;

import java.util.Arrays;

/*

Heap sort using max heap ==> extract max out and re-arrange array from last index to first (reverse) - this is in place solution since no need for extra space
Heap sort using min heap ==> extract min out get the array in sorted order


Heap sort is a comparison based sorting technique based on Binary Heap data structure.
It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element.

TC - O(nlogn)
SC - in place - no additional space (put aside stack space in recursion)
stable - no (if elements are repeated 4a and 4b) - it could scramble up


 */
public class HeapSort {

    public static void heapsort(int[] a) {
        int n = a.length;

        // Build heap (rearrange array)
        for(int i = n/2 -1; i >=0; i--) {
            heapify(a, n, i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            swap(a, 0, i);
            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
/*
if this is the given array, how to heapify (index and values are same)
                     0
              1            2
          3     4       5     6
       7   8  9  10


                     0
              1            2
          3     10       5     6
       7   8  9   4

                     0
              1            2
          8     10       5     6
       7   3  9   4


                     0
              1            6
          8     10       5    2
       7   3  9   4

                     0
             10           6
          8     1       5    2
       7   3  9   4

                     0
             10           6
          8     9       5    2
       7   3  1   4

                   10
             0            6
          8     9       5    2
       7   3  1   4


                   10
             9            6
          8     0       5    2
       7   3  1   4


                   10
             9            6
          8     4       5    2            /// THIS IS the state after heapify is run from n/2 to 0
       7   3  1   0                      // from letf to right this array is now 10, 9, 6, 8, 4, 5, 2, 7, 3, 1, 0


now extract maximum from the max heap, and swap it with the last element in array (this last element will be the maximum in the array)
this is why it becomes the in place solution and then heapify to rebalance


                   0
             9            6
          8     4       5    2            // extract max is removing 0th element which was 10 here and swap it with last element
       7   3  1   10


                   9
             8            6
          7     4       5    2            // heapify / rebalance heap except the last element in the array
       0   3  1   10                      // this is after one extract max and heapify (first iteration)


                     0
              1            2
          3     4       5     6          // after n - 1 extract max and heapify you get the sorted array
       7   8  9  10

 */
    private static void heapify(int a[], int n, int i)
    {
        int max = i;  // Initialize max as root or i
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is greater than root
        if (l < n && a[l] > a[max])
            max = l;

        // If right child is greater than max so far
        if (r < n && a[r] > a[max])
            max = r;

        // If max is not root
        if (max != i)
        {
            swap(a, i, max);
            // Recursively heapify the affected sub-tree
            heapify(a, n, max);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int[] a = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));

        heapsort(a);
        System.out.println(Arrays.toString(a));
    }
}
