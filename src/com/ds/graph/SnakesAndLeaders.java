package com.ds.graph;

import java.util.*;

/*

https://leetcode.com/problems/snakes-and-ladders/

1. Clarity
---------


2. Algo / DS
-------------
it doesn't say anything like graph.

steps - are node 1 ...N2
1-2
2-3
they are all edges (snake, ladder)
also asked for shortest move (shortest half) -- strong signal its a graph

so here graph > construction - no
Graph > traverse - its not directed, rolling dice only moves one direction, this mean its a directed graph
for directed -- DFS, TFS, topo sort, its not topo sort because its not dependecies
so it can be directed bfs or dfs (here snack is coming back so but undirected  - everything edge is multi directional)
shortest path is more leaning towards bfs


3. dataFlow (TC / SC)
--------------------
nodes are connected - incrementing / connecting with each other one at a time neigbhors

0: []
1: []
2: []

snake and ladder is a special case  - use map for each
after this we use BFS Queue

TC: traverse O(N+E) >-- here number of Nodes is N*N (so N2), every single node as six edges (six dice rolls), so E: 6 (N * N) - 6N2 - so O(N2)
SC: for Queue its O(N2)


4. Execution

 */
public class SnakesAndLeaders {

    /*
    return moves
     */
    private static int snakeAndLeaders(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // total cell numbers
        int target = rows * cols;

        // snake and leader maps
        Map<Integer, Integer> snakeAndLadderMap = new HashMap<>();

        // visited
        Set<Integer> visited = new HashSet<>();

        // construct snakes and ladder Map (key -- original index, value - target index)
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] != -1) {
                    // convert i, j into game index number
                    int index = rowscolstoIndex(i, j, rows, cols);

                    // assign target value into snake and ladder map
                    snakeAndLadderMap.put(index, board[i][j]);
                }
            }
        }

        // create queue for BFS traversal
        Queue<GraphObj> queue = new LinkedList<>();

        // add first index and global moves as 0
        queue.add(new GraphObj(1, 0));
        visited.add(1); // add first index as visited

        while (!queue.isEmpty()) {
            GraphObj current = queue.poll();

            int index = current.index;
            int globalmoves = current.globalMoves;

            // if reach target index, return globalmoves
            if(index == target) {
                return globalmoves;
            }

            // traverse to all neighbors with dice roll (1 to 6)
            for(int i = 1; i <= 6; i++) {

            }
        }

        return 0;

    }

    private static int rowscolstoIndex(int i, int j, int rows, int cols) {
        int base = (rows -i - 1) * cols;
        if((rows - i - 1) % 2 == 0) {
            return base + j + 1;
        } else {
            return base + cols - j;
        }
    }

    static class GraphObj {
        int index;
        int globalMoves;

        GraphObj(int index, int globalMoves) {
            this.index = index;
            this.globalMoves = globalMoves;
        }
    }

    public static void main(String[] args) {

    }
}
