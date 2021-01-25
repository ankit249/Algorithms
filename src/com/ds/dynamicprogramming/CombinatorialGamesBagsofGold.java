package com.ds.dynamicprogramming;

/*

Very rare that this kind of questions come

Games without element of chance:
shuffle cards / roll dice are not combinatorial games
THere are always two players and figure out / play perfectly
Zero Sum game is like - if 1 player wins the game by +10, other player looses by -10 (thats why they are called zero sum)

DESCRIPTION
-----------

bags with gold coins

        5   10   6   2
        --------------
bags of gold they are lined up left to right
Rule: On their turn a player removes and keeps either the left most or the right most bag (but can't remove from middle)

Question
--------
What happens to my player that goes first since its desribale to have more gold


Game states
bags = [5, 10, 6, 2]
                          5,10,6,2               Player A
                          /        \
                     10,6,2        5,10,6        Player B
                     /      \     /   \
                    6,2      10,6     5, 10      Player A
                   /    \   /    \   /    \
                  2       6       10       5     Player B

Observations
- Only our turn every other move
- keep track of our gold and oppenents gold, but at the end our opponents get what we didn't get
- so out of total if we maximize what we get => enough to track no need to track opponents gold

The goal is we maximize our gold, opponent maximize their gold
=> we maximize our gold and our opponent minimizes our gold

how can i start writting formula without writting too many cases

gold[-] := amount of gold that goes to the player whose turn it is

if gold[x] = x (only one bag left -- easiest case)
if two bags of gold left gold[x,y] = max(x,y)
if there are three bags of gold[x,y,z] = max[{ x + min(y,z) }, {z + min (x, y) } ]


gold[l,l',....r',r]  = max {
                    l + min(gold[..r',r], gold[l'..r'])
                    r + min(gold[l'...r'], gold[l,l'...])
                    }

example
gold[5,10,6,2]  = max  {
                    5 + min(gold(6,2), gold(10,6)),
                    2 + min(gold(10,6), gold(5,10))
                    }
                = max {
                     5 + min(max(6,2), max(10,6)),
                     2 + min(max(10,6), max(5,10))
                    }
                = max {
                    5 + min(6,10)
                    2 + min(10,10)
                 }
                = max { 5 + 6, 2 +10 }
                = max (11, 12)
                = 2


bags = [5, 10, 6, 2]
                         l = 0 , r = 3
                          5,10,6,2                      Player A
                          /        \
      l=1,r=3       10,6,2        5,10,6                Player B
                     /      \     /   \
       l=2,r=2     6,2      10,6     5, 10   l=0,r=1    Player A
                   /    \   /    \   /    \
       l=r=3     2       6       10       5  l=r=0      Player B


 */


public class CombinatorialGamesBagsofGold {

    /*
    Python code:

    gold = {}
    for numOfBags in range(1, len(bags) + 1):
        for lft in range(len(bags) - numOfBags +1 ):
            right = lft + numberBags - 1
            if numberBags == 1:
                gold[(lft,right)] = bags[lft];
            else if numberBags == 2:
                gold[(lft,right)] = max(bgs[lft], bags[right])
            else:
                gold[(lft,right)] = max(
                        bags[lft] + min(gold[lft+2,right)], gold[(lft+1,right-1)]),
                        bags[right] + min(gold[lft+1,right-1)], gold[(lft,right-2)]))
     return gold[(0,len(bags)-1)]

     */

    /*
    in java
       l     0   1   2   3
       r
       0     5
       1    10  10
       2        10   6
       3             6   2

     */


    public static void main(String[] args) {

    }
}
