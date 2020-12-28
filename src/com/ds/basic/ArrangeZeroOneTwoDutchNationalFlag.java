package com.ds.basic;

/*

Dutch National Flag
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).

Example
Input: [G, B, G, G, R, B, R, G]
Output: [R, R, G, G, G, G, B, B]
There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.

Notes
Input Parameters: An array of characters named balls, consisting of letters from {‘R’, ‘G’, ‘B’}.
Output: Return type is void. Modify the input character array by rearranging the characters in-place.

Constraints:

1 <= n <= 100000
Do this in ONE pass over the array - NOT TWO passes, just one pass.
Solution is only allowed to use constant extra memory.
 */

//// ANSWER EXPLANATION
/*

lo                          hi
G,  B,  G,  G,  R,  B,  R,  G
mid

lo                          hi
G,  B,  G,  G,  R,  B,  R,  G
   mid

lo                      hi
G,  G,  G,  G,  R,  B,  R,  B
   mid

lo                      hi
G,  G,  G,  G,  R,  B,  R,  B
       mid

lo                      hi
G,  G,  G,  G,  R,  B,  R,  B
           mid

lo                      hi
G,  G,  G,  G,  R,  B,  R,  B
               mid

    lo                  hi
R,  G,  G,  G,  G,  B,  R,  B
                   mid

    lo              hi
R,  G,  G,  G,  G,  R,  B,  B   until hi >= mid
                   mid


        lo          hi
R,  R,  G,  G,  G,  G,  B,  B
                       mid


*/

public class ArrangeZeroOneTwoDutchNationalFlag {

    public static void arrangeInOnePass(char[] input) {
        int lo = 0;
        int mid = 0;
        int hi = input.length - 1;
        while(mid <= hi) {
            if(input[mid] == 'R') {
                swap(input, lo, mid);
                lo++;
                mid++;
            } else if(input[mid] == 'G') {
                mid++;
            } else if(input[mid] == 'B') {
                swap(input, mid, hi);
                hi--;
            }
        }
    }

    public static void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        char[] arr = new char[] {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
        System.out.println("input: " + new String(arr));

        arrangeInOnePass(arr);
        System.out.println("input: " + new String(arr));
    }
}
