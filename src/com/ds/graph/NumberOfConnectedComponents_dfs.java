package com.ds.graph;


import java.util.*;
/*

http://buttercola.blogspot.com/2016/01/leetcode-number-of-connected-components.html


GRAPH > dfs

can also be solved by union find


(1) Clarity
(2) Data Structure decision
(3) Data Flow - TC / SC
(4) Execution
    - High level frame
    - frame all details
    - corner cases



 */
public class NumberOfConnectedComponents_dfs {

    // global count
    static int res = 0;

    private static void countComponents(int n, int[][] edges) {

        res = 0;

        // visited node set
        Set<Integer> visited = new HashSet<>();
        List[] adjlist = buildAdjlist(n, edges);

        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) continue;;

            // traverse from node i with all connected nodes
            dfs(i, adjlist, visited);

            // visted all nodes connected to i, increase global count
            res++;
        }
    }

    private static List[] buildAdjlist(int n, int[][] edges) {

        List[] adjlist = new List[n];

        for(int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {
            adjlist[edge[0]].add(edge[1]);
            adjlist[edge[1]].add(edge[0]);
        }

        return adjlist;
    }

    private static void dfs(int node, List[] adjlist, Set<Integer> visited) {
        // add the current node to visited set
        visited.add(node);

        // get the neighbors and dfs
        List<Integer> neighbors = adjlist[node];
        for (int neighbor : neighbors) {
            if(!visited.contains(neighbor)) {
                dfs(neighbor, adjlist, visited);
            }

        }

    }

    public static void main(String[] args) {
        /*
        int n = 5;
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} };
        countComponents(n, edges);
        System.out.println(res);
        */
        int n = 5;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {3, 4} };
        countComponents(n, edges);
        System.out.println(res);

    }
}
