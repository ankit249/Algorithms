package com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/*

recursive functions are always depth first

return all permutation of given input
Example: input = [1, 2, 3]
Output = [[1,2,3],[1,3,2],
          [2,1,3],[2,3,1],
          [3,1,2],[3,2,1]]

Approach 1
----------
                                        [1,2,3] available
                                           [] slate

            [2,3] available             [1,3] available                     [1,2] available
            [1] slate                    [2] slate                          [3] slate


    [2] available  [3] available     [1] available  [3] available           [2] available  [1] available
    [1,3] slate    [1,2] slate       [2,3] slate    [2,1] slate             [3,1] slate    [3,2] slate


    [] available    [] available     [] available    [] available           [] available    [] available
    [1,3,2] slate   [1,2,3] slate    [2,3,1] slate   [2,1,3] slate          [3,1,2] slate   [3,2,1] slate


Approach 2
----------

Instead of keeping two list, we would merge the available and slate list

                                      [1,2,3]
                      /                 |                       \
              [1,2,3]                [2,1,3]                    [3,1,2]
           /        \              /       \                   /     \
       [1,2,3]    [1,3,2]     [2,1,3]    [2,3,1]          [3,2,1]   [3,1,2]
          |          |            |         |               |          |
       [1,2,3]    [1,3,2]     [2,1,3]    [2,3,1]          [3,2,1]   [3,1,2]

slate in this tree is the concatination of available and slate in option 1
placed - is number of elements in their final position

you need for loop here because recursion is not always like tree goes from 3 forks to 2 forks to 1 fork


TC - O(n!)   ==> to be precise n * n!
SC - complexity of approach1 and approach2 is same for space, O(n!) ==> to be precise n * n!
 */
public class AllPermutations {

    private static List<List<Integer>> permutations(List<Integer> input) {
        var results = new ArrayList<List<Integer>>();
        helper(new ArrayList<>(input), 0, results);
        return results;
    }

    private static void helper(List<Integer> slate, int placed,List<List<Integer>> results)  {
        if(placed >= slate.size()) {
            results.add(new ArrayList<>(slate));
            return;
        }
        for(int i = placed; i < slate.size(); i++) {
            swap(slate, i, placed);   // modify slate
            helper(slate, placed + 1, results);
            swap(slate, placed, i);   // always unmodify it back before going back up on the tree (always)
        }
    }

    private static void swap(List<Integer> slate, int i, int j) {
        int tmp = slate.get(i);
        slate.set(i, slate.get(j));
        slate.set(j, tmp);
    }


    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<List<Integer>> result = permutations(input);
        System.out.println(result);
    }
}
