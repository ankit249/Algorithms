package com.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class snakesandleaders {

    private static void snakeAndLeaders(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // total cell numbers
        int target = rows * cols;

        // snake and leader maps
        Map<Integer, Integer> snakeAndLadderMap = new HashMap<>();

        // visited
        Set<Integer> visited = new HashSet<>();


    }

    public static void main(String[] args) {

    }
}
