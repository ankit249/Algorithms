package com.ds.dynamicprogramming;
/*
// COUNTING PROBLEM (one of it which can be solved by DP)

Possible scores in American Football - 2, 3, 6  (Our version)
Q. Given a final score S - how many ways are there to reach S

Example: Final Score = 7 ( 2>2>3  or  2>3>2 or 3>2>2)

THOUGHTS should be,

how many ways you can get to 5 (broken down to subproblem),
I have seen problems where you've been asked count number of ways so i strongly suspect DP.

so lets go by examples:
for 0 score - The way to score 0 would be no score (because you didn't score)

so for score 8 > if the last score was 2, what could have happened before that (black box 6 < we already know this)





final scroe:     0      1       2       3       4       5       6       7       8
----------------------------------------------------------------------------------
    #ways        1      0       1       1       1       2       3       3       6
                                               2>2    2>3      2>2>2  2>2>3
                                                      3>2      3>3    2>3>2
                                                                6     3>2>2


score before     black box        how to end at 8
      6           2>2>2                 2
                   3>3                  2
                   6                    2

      5           2>3                   3
                  3>2                   3

      2            2                    6

no. of ways to score (S) = no. of ways s=2 + no of ways s=3 + no. of ways s = 6
The formula is not mathematically commplete
now(s) = 1 if s = 0
now(s) = 0 if s < 0

same no. of ways to score 7 would be -- how you get to ends in 2, 3 and 6 (fro from 5, 4 and 1)

for dp 10 min to write code

TC: O(finalsocre)
SC: O(finalscore)


This is a bottom up tabulation solution, you can also use top down memoization, if they question is given like of example no. of ways of 6 is given then top down memoization,
whereas in bottom up tabulation we are actually building the table from bottom

 */
public class AmericanFootballScores {

    /*

    TC: O(finalsocre)
    SC: O(finalscore)
    */
    public static int numberOfWays(int finalscore) {
        if(finalscore < 0) return 0;
        int[] now = new int[finalscore + 1]; // <- always one more entry in the table (come back to the efficient solution afterwards - always say this while writting it here - i will see if i can space optimize it letter)

        now[0] = 1;
        for(int s = 1; s <= finalscore; s++) {
            now[s] =  (s >= 2 ? now[s - 2] : 0)
                    + (s >= 3 ? now[s - 3] : 0)
                    + (s >= 6 ? now[s - 6] : 0);
        }
        return now[finalscore];
    }

    /*

    TC: O(finalsocre)
    SC: O(1)  <-- only 6 slots needed
    */
    public static int numberOfWaysSpaceOptimized(int finalscore) {
        if(finalscore < 0) return 0;
        int[] now = new int[6]; // <- always go 6 slots back.

        now[0] = 1;
        for(int s = 1; s <= finalscore; s++) {
            now[s % 6] =  (s >= 2 ? now[(s - 2) % 6] : 0)
                        + (s >= 3 ? now[(s - 3) % 6] : 0)
                        + (s >= 6 ? now[(s - 6) % 6] : 0);
        }
        return now[finalscore % 6];
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("numberOfWays...");
        for (int i = 0; i <= 8; i++) {
            System.out.print(numberOfWays(i) + " ");
        }
        System.out.println();

        System.out.println("numberOfWaysSpaceOptimized...");
        for (int i = 0; i <= 8; i++) {
            System.out.print(numberOfWaysSpaceOptimized(i) + " ");
        }

    }
}
