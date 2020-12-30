package com.ds.sort;

import java.util.Arrays;

public class RadixSort {

/*

PASS 1 (get all the digits from the last)
------

31, 755, 44, 301, 234, 60, 1

    1
    301
60  31        43    234   755
0    1    2    3     4     5     6    7    8   9

1    4    4    5     6     7     7    7    7   7    // count array

60   301  1   31   43    234   755                  // output array


PASS 2 (get all the digits from the middle)
------

60   301  1   31   43    234   755

1             234
301           31     43   755   60
0    1    2    3     4     5     6    7    8    9

2    2    2    4     5     6     7    7    7    7   // count array

301  1   31   234   43   755   60                   // output array

PASS 3 (get all the digits from the front)
------

301  1   31   234   43   755   60


60
43
31
1        234   301                    755
0    1    2    3     4     5     6    7     8    9

4    4    5    6     7     6     6    7     7    7   // count array

1   31   43   60    234   301   755                  // output array (sorted after 3 passes)




*/

/*
TC - O(n)
SC - O(n)
stable - no
 */
    private static void radixsort(int[] a, int max) {
        for(int j = 0; j < max; j++) {   // max will be 3 (d times) for numbers <= 999, for number<= 9999 it will be 4 passes
            int exp = (int) Math.pow(10, j);


            // count array is 0 to 9 -- possible buckets since we use modulo possible digts can be 0 to 9
            int[] count = new int[10];
            int[] output = new int[a.length];


            for(int i = 0; i < a.length; i++) {
                count[(a[i] / exp) % 10] ++;
            }

            for(int i = 1; i < 10; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for(int i = a.length - 1; i >= 0; i--) {
                output[count[(a[i] / exp) % 10] - 1] = a[i];
                count[(a[i] / exp) % 10] --;
            }

            for(int i = 0; i < output.length; i++) {
                a[i] = output[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {31, 755, 43, 301, 234, 60, 1};
        //int[] a = new int[] {31, 755, 43, 301, 234, 60, 1, 88, 99};
        System.out.println(Arrays.toString(a));

        // find maximum digit length
        int max = findMaxDigits(a);
        radixsort(a, max);
        System.out.println(Arrays.toString(a));
    }

    private static int findMaxDigits(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) {
            int digits = String.valueOf(a[i]).length();
            max = Math.max(max, digits);
        }
        return max;
    }
}
