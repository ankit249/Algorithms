package com.ds.graph;

/*

http://buttercola.blogspot.com/2015/08/leetcode-graph-valid-tree.html

1 clarity
---------
                   Graph      Tree

cycle               yes        no
all connected       no         yes


2   ds / alog
--------------
how to know tree and graph
every time we see node > its either node, graph
root == tree
leaves == tree
edges / undirected == graph

For Graph -- this is not a construction problem, this is traversal
its traversal problem -- undirected -- both bfs/dfs work

to find cycle -- dfs is more favored, bfs still works

3 dataflow , TC / SC analysis
-----------------------------
TC : given this is undirected graph, 2 things to check, cycle or connected

cycle:      traverse -- all nodes / edges in the graph which is O(N+E)
connected:  traverse -- all nodes / edges in the graph which is O(N+E)  [ if some are visited and some are not -- its not connected ]

so TC is O(N+E) + O(N+E) == O(N+E)

WNY N + E > graph can be connected(nodes and eges are equal) - sometimes more edges than nodes or  non connected(where nodes are more than edges) so in general
its alwasy N + E

SC:  visited which O(N) and dfs -- call stack O(N), adjlist is O(N) == O(N)

4 Execution
-----------
 -- high level frame
 -- frame all details
 -- corner cases

 hascycle explanation
[[0, 1], [0, 2], [0, 3], [1, 4]]

0: visited {0} parent {-1}
1: visited {0,1} parent {0}
2: visited {0,1,2} parent {1}
3: visited {0,1,2,3} parent {2}

now 3 has a neighbor 1 -- is nnot parent of 3, i was visited before

 */

import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {


    private static boolean validTree(int n, int[][] edges) {
        // visited node set
        Set<Integer> visited = new HashSet<>();

        // build adjlist to represnet the graph
        List[] adjlist = buildAdjlist(n, edges);

        // detect cycle, if yes return false
        if(hasCycledfs(0, adjlist, visited, -1)) {
            return false;
        }

        // detect all connected in a graph, if not return false
        if(visited.size() != n) {
            return false;
        }

        return true;
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

    private static boolean hasCycledfs(int node, List[] adjlist, Set<Integer> visited, int parent) {
        // add the current node to visited set
        visited.add(node);

        // get the neighbors and dfs
        List<Integer> neighbors = adjlist[node];

        for (int neighbor : neighbors) {
            // if the neighbor is parent, skip and continue
            if(neighbor == parent) continue;

            // if the neighbor was visited before, we found a cycle
            if(visited.contains(neighbor)) return true;

            /// pass in node as the partent to the neighbor
            if(hasCycledfs(neighbor, adjlist, visited, node)) {
                // cycle detected
                return true;
            }
        }

        // no cycle return false
        return false;

    }



    public static void main(String[] args) {
        /*
        // not a valid tree
        int n = 5;
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} };
        System.out.println(validTree(n, edges));

         */

        /*
        // not a valid tree
        int n = 3;
        int[][] edges = { {0, 1}, {1, 2}, {2, 0} };
        System.out.println(validTree(n, edges));

         */

        /*
        // valid tree
        int n = 4;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3} };
        System.out.println(validTree(n, edges));
        */

        /*
        For example:
        Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
        Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
         */

        /*
        // valid tree
        int n = 5;
        int[][] edges = { {0, 1}, {0, 2}, {0, 3}, {1, 4} };
        System.out.println(validTree(n, edges));
        */

        // not valid tree
        int n = 5;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4} };
        System.out.println(validTree(n, edges));


    }
}
