package com.ds.dynamicprogramming;

/*

// OPTIMIZATION PROBLEM (one of it which can be solved by DP)
MEMORIZE THIS: in the optimization problems where we continue the sequence, consider storing the value of all choices into the DP table
Reason: what is the best now might not be the best choice when looking at the complete picture

VERY COMPLICATED PROBLEM
- There are 2 product to sell A and B,
- There is only one machine to produce A or B (One product per day) (Every day i can either produce A or B but not both)
- changing production from A-> B or B -> A requires reconfiguring machine which takes a day (On this day i produce nothing)

Question: Given a forecase, find the maximum profit
-----------------------
Example forecast:
---------------
    day     1   2   3   4
    A      $4  $2  $1   $7
    B      $1  $2  $5   $4






THIS IS WHAT YOU NEED TO THINK
Firstday you don't need to configure - you can start producing A or B
First thing i realized - i can make the problem smaller (either take a product away or take the day away) -- however taking the product away is not an option, so take the day
it seems like optimization question which i know is a DP problem
smallest example is just looking first day (puzzles / examples)

if #days = 1 ,
        day1   A (profit $4)
        Total profit = $4

if #days = 2 ,  ( you can produce A>A, B>B, A>reconfigure or B>reconfigure , ask if profit can be negative -- here its no)
        day1   A (profit $4)
        day2   A (profit $2)
        Total profit = $6

if #days = 3 , (you can just produce B>B>B, A>reconfigure>B
        day1   A (profit $4)
        day2   reconfigure
        day3   B (profit $5)
        Total profit = $9

if #days = 4 ,
        day1   A (profit $4)
        day2   A (profit $2)
        day3   A (profit $1)
        day4   A (profit $7)
        Total profit = $14

THE PROBLEM is here is if #days=4 then its not best of #days for 3
if i look furthur back #days =2 then its AA
so to get to Day 4 -- you can either get to day 4 from day3 or day2

OPTIMIZATION PROBLEMS asks us to make choices
---------------
LETS THINK THIS DIFFERENTLY
DP problems with table like input

if the input to DP problem is a table then the DP table often has the same structure as the input but a different interpretation

input    day1   day2    day3    day4
  A        4     2       1       7
  B        1     2       5       4
                         |
forecasted profit for selling B on day 3

DP TABLE

 day    1   2   3   4
 A      4   6   7   14
 B      1   3   9   13
                |
      solution to a subproblem needs to be max profit on day1, day2 and day3 under the constraint that we produce B on day3

on the first day under the constraint you produce A max profit is 4
on the first day under the constraint you produce B max profit is 1
on the first two day under the constraint you produce A on the second day max profit is 6
on the first two day under the constraint you produce B on the second day max profit is 3
on the third day under the constraint you produce A on the third day max profit is 7
on the third day under the constraint you produce B on the third day max profit is 9 (because you can produce A on day 1, reconfigure and produce B on thrirday day)
on the fourth day under the constraint you produce A on the fourth day max profit is 14
on the fourth day under the constraint you produce B on the fourth day max profit is 13 ( A > reconfigure > B > B)


SO PROFIT for producting

profit(A, d) = max { profit(A, d -1) , prodift(B, d - 2) } + forecast(A,d)
profit(B, d) = max { profit(B, d -1) , prodift(A, d - 2) } + forecast(B,d)

THIS IS HOW THE DP table was generated
 day    1   2   3   4
 A      4   6   7   14
 B      1   3   9   13
 */
public class ProductPlan {

    /*
    TC: 1 look , number of days O(days)
    SC: 2 * days : O(days)

    if there are more than 2 product
    TC: max becomes loop -- because its not max of 2, O(Days. P2)
    SC: O(product. days) O(P)

    */
    public static void productionPlan(int[][] forecast) {
        // tell verbally to interview what to do -- forecast can't contain multiple numbers
        //validateInput(forecast);
        final int A = 0, B = 1;
        int days = forecast[A].length;
        int lastday = days - 1;

        int[][] profit = new int[2][days];  // mention here you will come back with space optimized soln

        for(int d = 0; d < days; d++) {
            profit[A][d] = Math.max(d >= 1 ? profit[A][d - 1] : 0, d >= 2 ? profit[B][d - 2]: 0) + forecast[A][d];
            profit[B][d] = Math.max(d >= 1 ? profit[B][d - 1] : 0, d >= 2 ? profit[A][d - 2]: 0) + forecast[B][d];
        }
        int maxProfit = Math.max(profit[A][lastday], profit[A][lastday]);
        System.out.println("Maximum Profit: " + maxProfit);
        /// THIS ANSWERS the maximum profit


        /// FROM THIS POINT ITS THE CODE TO PRING
        int d = lastday;
        int p = (maxProfit == profit[A][d] ? A : B);
        System.out.println("for days: " + d + " profit: " + p);
        while(d > 0) {
            if(profit[p][d] == profit[p][d - 1] + forecast[p][d]) {
                d--;
            } else {
                System.out.println("switch from days: " + d + " to day - 1: " + (d - 1));
                d = d - 2;
                p = (p == A? B: A);
            }

            System.out.println("product: " + p + " and days: " + d);
        }

    }

    /*
    TC: 1 look , number of days O(days)
    SC: 2 * days : O(1) <-- could be O(1) because i am not looking beyond two days
    TODO
    */
    /*
    public static void productionPlanSpaceOptimized(int[][] forecast) {
        // tell verbally to interview what to do -- forecast can't contain multiple numbers
        //validateInput(forecast);
        final int A = 0, B = 1;
        int days = 2;
        int lastday = (days - 1) % 2;

        int[][] profit = new int[2][days];  // mention here you will come back with space optimized soln

        for(int d = 0; d < days; d++) {
            profit[A][d % 2] = Math.max(d >= 1 ? profit[A][(d - 1) % 2] : 0, d >= 2 ? profit[B][(d - 2) % 2]: 0) + forecast[A][d % 2];
            profit[B][d % 2] = Math.max(d >= 1 ? profit[B][(d - 1) % 2] : 0, d >= 2 ? profit[A][(d - 2) % 2]: 0) + forecast[B][d % 2];
        }
        int maxProfit = Math.max(profit[A][lastday], profit[A][lastday]);
        System.out.println("Maximum Profit: " + maxProfit);
        /// THIS ANSWERS the maximum profit
    }
     */



    public static void main(String[] args) {
        System.out.println();
        System.out.println("ProductPlan...");
        int[][] forecast = new int[][] { {4,2,1,7}, {1,2,5,4}};
        productionPlan(forecast);
        System.out.println();

        //productionPlanSpaceOptimized(forecast);
        System.out.println();

    }
}
