package com.ds.basic;
// Leetcode 457

public class CircularArrayLoop {


    /*

    for i in 0 to n - 1:
        // start from nums[i] and ssee if you end up in a special cycle, if yes return true
        hare = i;
        tortoise = i;
        while True:
            hare = f(f(hare))
            tortoise = f(tortoise)
            if hare == tortoise // there must be a cycle
                // check if its a special cycle
                // length of the cycle has to be more than 1,
                third = tortoise;
                count = 1;
                while f(third) != tortoise:
                    third = f(third)
                    count++;
                // count here as cycle length
                if count > 1:
                    return true;
                else:
                    break
    return false;




       function f(x):
            return (x + num[x]) % lenth(nums)
     */
}
