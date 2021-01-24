package com.ds.dynamicprogramming;

/*
A="xxyx"
B="xzy"
Interleaving of A and B has all characters of A and B with order preserved

Examples
--------
    x xz xy y x  <-- valid
    --------
    A B A B A


    xxyxyz => invalid -- z out of order
    xzyxxyx => valid, Special case B concatenated A
    xxxzyy => invalid - missing one x
    xxxzyyx => valid
    xzxxyxy  => valid

Interview Question
--------

Given 3 strings A, B and C, return true if and only if C is a valid interleaving of A and B

Suboptimal solution
A="abc"
B="123"
C=""a12b3c"
 you can solve this with two pointers because different character sets

A="xxz"
B="xxy"
C="xxzxxy"
 you can also solve this with recursion tree
                  .
               A/  \B
               .   .
            A/  \B
           .      .
         A/ \B  A/ \B
        .    .  .  .

 This is Exponenetial solution O(2^n)

Better solution is DP table
A= "xxyx"
B = "xzy"
C = "xxzxyyx"

Take all prefixes of A first



        A          ""          "x"               "xx"                "xxy"            "xxyx"
        B
        ""          T           T                 T                  F                  F
        "x"         T           T                 F                  F                  F
        "xz"        F           T                 T*                 T                  F
        "xzy"       F           F                 T                  T                  T

*ZOOMED in version of the cell
        A = xx (first two chars of A)
        B = xz (first two chars of B)
        C = "xxzx"  A(EntireB)A -- this is interleaving
        Interleaving must be 4 characters of string



Recursive patterns in two dimensional DP tables
  -> Increasing problem size

4 optionals on how to select the value
(1)
. x
x result

(2)
x x
x result

(3)
      x
      x
x x   result

(4)
x x   x   .
x x   x   .
x x   result



interleaving(ai, bj) = interleaving(ai - 1, bj) && A[ai] == C[ai + bj]
                        ||
                    interleaving(ai - 1, bj - 1) && B[bj] == C[ai + bj]



 */
public class InterleavingStrings {

    /*
    TC: O(a.length * b.length)
    SC: O(a.length * b.length) but in the space optimized version could O(a.length + b.length) -- you only need two rows
     */
    static boolean interleavingStrings(char[] a, char[] b, char[] c) {

        if(a.length + b.length != c.length) return false;

        boolean[][] dp = new boolean[a.length + 1][b.length + 1]; // <- come back to if you can space optimize it

        for(int ai = 0; ai <= a.length; ai++) {
            for(int bj = 0; bj <= b.length; bj++) {
                dp[ai][bj] = (ai == 0 && bj ==0)
                        || (ai >= 1 && dp[ai - 1][bj] && a[ai - 1] == c[ai + bj - 1])
                        || (bj >= 1 && dp[ai][bj - 1] && b[bj - 1] == c[ai + bj - 1]);


            }
        }

        return dp[a.length][b.length];
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("interleavingStrings...");

        String A = "xxyx";
        String B = "xzy";
        String C = "xxzxyyx";

        System.out.println(interleavingStrings(A.toCharArray(), B.toCharArray(), C.toCharArray()));

    }

}
