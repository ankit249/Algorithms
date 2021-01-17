package com.ds.graph;

import javax.swing.*;
import java.util.*;

/*
https://leetcode.com/problems/is-graph-bipartite/

1. Clairty
----------
- input is adjcency list is given
- no self edge, parelel edge
- bipartite - split the nodes to into 2 groups such that, two nodes from every single edge are from different group

for input graph  - this is bipartite graph
1-0-2-3-4   G1    G2
            0      1
            3      2
                   4

for input graph
   0
  /  \         G1    G2
 1 -- 2        0     1, 2
 1-- 2 would be in same Group G2 so its not bipartite graph

For input graph
  0 -  1
  |    |        G1       G2
  3 -- 2        0,2      1,3
this is bipartite graph

2. DS/ Algo
-----------
- its a graph > is it construction / traversal > its not construction - its traversal
- traversal (undirected, directed) - this is undirected traversal - bfs, dfs
-- both dfs/bfs works, none of them is better we would use dfs


3. Data Flow (TIME / Space)
---------------------------
- TC : first we have to traverse every single node so its O(N+E), do we need to traverse one node multipe times - no os O(N+E)
- SC: visited O(N), because we are using dfs -- call stack O(N) -- so its O(N) total space

4. Execution
------------

use Integer group 0, 1





 */
public class BipartiteGraph {

    public static boolean isBipartite(int[][] graph) {
        // visited node set
        Map<Integer, Integer> visited = new HashMap<>();

        List[] adjlist = buildAdjlist(graph);

        for(int i = 0; i < adjlist.length; i++) {
            // if i is visited skip
            if(visited.containsKey(i)) continue;;

            // given connected nodes with i as n invalid Bipartite, return faluse
            if(!dfs(i, adjlist, visited, 0)) {
                return false;
            }
        }


        // no invalid case
        return true;
    }

    private static List[] buildAdjlist(int[][] graph) {

        int n = graph.length;
        List[] adjlist = new List[n];

        for(int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList<>();

            for(int m : graph[i]) {
                adjlist[i].add(m);
            }
        }

        return adjlist;


    }

    private static boolean dfs(int node, List[] adjlist, Map<Integer, Integer> visited, int color) {
        // add node and color into visited map
        visited.put(node, color);

        // get the neighbors and dfs
        List<Integer> neighbors = adjlist[node];
        for(int neighbor : neighbors) {
            if(visited.containsKey(neighbor)) {
                if(visited.get(neighbor) == color) {
                    // my neigbhor has the same color as myself
                    return false;
                }
            } else {
                // continue travers, assign different color to the neighbor
                if(!dfs(neighbor, adjlist, visited, 1 - color)) {
                    return false;
                }
            }
        }

        // no invalid case, return true
        return true;
    }


    public static void main(String[] args) {
        // input is adjcency list given
        /*
        // Input: graph = [[1,3],[0,2],[1,3],[0,2]]
        // Output: true

        int[][] graph = { {1, 3}, {0, 2}, {1, 3}, {0, 2} };
        System.out.println(isBipartite(graph));
        */


        // Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
        // Output: false

        int[][] graph = { {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2} };
        System.out.println(isBipartite(graph));


    }
}
