package com.ds.sort;

import java.util.Arrays;

/*
Merge One Sorted Array Into Another
Given two arrays:
1) arr1 of size n, which contains n positive integers sorted in the ascending order.
2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).
Write a function that takes these two arrays, and merges the first one into second one, resulting in an increasingly sorted array of (2*n) positive integers.

Example

Input:
n = 3
arr1 = [1 3 5]
arr2 = [2 4 6 0 0 0]

Output: arr2 = [1 2 3 4 5 6]


// EXPLANATION

      i1            i2
1  3  5       2  4  6  0  0  0

      i1         i2
1  3  5       2  4  6  0  0  6

   i1            i2
1  3  5       2  4  6  0  5  6

   i1         i2
1  3  5       2  4  6  4  5  6

i1            i2
1  3  5       2  4  3  4  5  6


i1         i2
1  3  5       2  2  3  4  5  6


*/
public class MergeOneSortedArrayToOther {

    /*
     * Complete the merger_first_into_second function below.
     */
    static void merger_first_into_second(int[] arr1, int[] arr2) {
        int index1 = arr1.length - 1;
        int index2 = arr1.length - 1;
        int writeindex = arr2.length - 1;

        while(index1 >= 0 && index2 >= 0) {
            if(arr1[index1] <= arr2[index2]) {
                arr2[writeindex--] = arr2[index2--];
            } else {
                arr2[writeindex--] = arr1[index1--];
            }
        }

        while(index1 >= 0) {
            arr2[writeindex--] = arr1[index1--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3, 5};
        int[] arr2 = new int[] {2, 4, 6, 0, 0, 0};
        System.out.println(Arrays.toString(arr2));
        merger_first_into_second(arr1, arr2);
        System.out.println(Arrays.toString(arr2));

        arr1 = new int[] {4, 5, 6};
        arr2 = new int[] {1, 2, 4, 0, 0, 0};
        System.out.println(Arrays.toString(arr2));
        merger_first_into_second(arr1, arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
