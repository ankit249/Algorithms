package com.ds.dynamicprogramming;



/*
Number Of Paths In A Matrix



Consider a maze mapped to a matrix with an upper left corner at coordinates (row, column) = (0, 0).
You can only move either towards right or down from a cell. You must determine the number of distinct paths through the maze.
You will always start at a position (0, 0), the top left, and end up at (n-1, m-1), the bottom right. As an example, consider the following diagram where '1' indicates an open cell and '0' indicates blocked.
You can only travel through open cells, so no path can go through the cell at (0, 2). There are two distinct paths to the goal.
 */


/*


(1) YOU CAN DO DFS, or BFS (increment counter)
(2) or recursion
(3) or DP

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfPathsInMatrix {

    public static int numberOfPaths(List<List<Integer>> matrix) {

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) == 0) continue;
                int d1 = matrix.get(i).get(j-1);
                int d2 = matrix.get(i-1).get(j);
                int d3 = matrix.get(i-1).get(j-1);
                if(d1 == 0 || d2 == 0 || d3 == 0) {
                    matrix.get(i).set(j, Math.max(d1, d2));
                } else {
                    matrix.get(i).set(j, d1 + d2);
                }
            }
        }

        return matrix.get(rows - 1).get(cols - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 1, 0, 1));
        list.add(Arrays.asList(1, 1, 1, 1));

        System.out.println(numberOfPaths(list));
    }

}
