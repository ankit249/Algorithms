package com.ds.basic;

import java.util.Arrays;

/*
Group the numbers
You are given an integer array arr of size n. Group and rearrange them (in-place) into evens and odds in such a way that group of all even integers appears on the left side and group of all odd integers appears on the right side.
Example
Input: [1, 2, 3, 4]
Output: [4, 2, 1, 3]

Order does not matter. Other valid solutions are:

[2, 4, 1, 3]
[2, 4, 3, 1]
[4, 2, 3, 1]
 */
public class OddEvenGroup {

    /*
     * Complete the function below.
     */
    private static int[] solve(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            if(arr[hi] % 2 == 0 && arr[lo] % 2 == 1) {
                int tmp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = tmp;

                lo++;
                hi--;
            }

            if(arr[lo] % 2 == 0) lo++;
            if(arr[hi] % 2 == 1) hi--;
        }

        return arr;
    }

    // can also be solved with dijkstra's method
/*

lo
1, 2, 3, 4
mid


lo
1, 2, 3, 4
  mid

   lo
2, 1, 3, 4
     mid

   lo
2, 1, 3, 4
        mid

      lo
2, 4, 3, 1
           mid

*/
    private static int[] solveUseStartPointers(int[] arr) {
        int lo = 0;
        int mid = 0;

        while(mid < arr.length) {
            if(arr[mid] % 2 == 1) {
                mid++;
            } else {
                swap(arr, lo, mid);
                lo++;
                mid++;
            }
        }

        return arr;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(a));
        solve(a);
        System.out.println(Arrays.toString(a));

        a = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(a));
        solveUseStartPointers(a);
        System.out.println(Arrays.toString(a));

    }


}
