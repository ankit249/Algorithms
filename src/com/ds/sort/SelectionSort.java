package com.ds.sort;

import java.util.Arrays;

public class SelectionSort {
/*

min
32, 16, 15, 18, 2, 40, 3, 38
i   j
*/
    // TC - O(n2), SC - In place O(1)
    // stable - no because e.g  3b 3a 2 1 would be sorted  1 3a 2 3b (after st iteration) so its not preserving the order -- thats why its not stable
    public static void selectionsort(int[] a) {
        for(int i = 0 ; i < a.length - 1; i++) {
            int min = i;
            for(int j = i; j < a.length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 32, 16, 15, 18, 2, 40, 3, 38 };
        System.out.println(Arrays.toString(a));
        selectionsort(a);
        System.out.println(Arrays.toString(a));
    }
}
