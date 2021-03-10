package com.ds.linklist;

public class HappyNumber {

    // Utility method to return sum of square of
// digit of n
    static int numSquareSum(int n)
    {
        int squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }

    //  method return true if n is Happy number
    // TC - O(logn), SC - O(1)
    // how logn, if there 2^31 numbers and all numbers are 9, lets say K then its 81 * K, 81 (logn) = logn
    static boolean isHappynumber(int n)
    {
        int slow, fast;

        //  initialize slow and fast by n
        slow = fast = n;

        do
        {
            //  move slow number
            // by one iteration
            slow = numSquareSum(slow);

            //  move fast number
            // by two iteration
            fast = numSquareSum(numSquareSum(fast));

        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        return (slow == 1);
    }

    //  Driver code to test above methods
    public static void main(String[] args)
    {
        int n = 13;
        if (isHappynumber(n))
            System.out.println(n + " is a Happy number");
        else
            System.out.println(n + " is not a Happy number");


        n = 15;
        if (isHappynumber(n))
            System.out.println(n + " is a Happy number");
        else
            System.out.println(n + " is not a Happy number");

    }
}
