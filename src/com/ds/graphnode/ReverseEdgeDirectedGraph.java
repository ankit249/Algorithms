package com.ds.graphnode;


import java.util.*;
/*
Given A Graph Build A New One With Reversed Edges
Given a strongly connected directed graph, build a new graph with the same number of nodes but every edge reversed. This is also called transposing a graph.


strongly connected graph means from one edge you can get to the other edge
-- they are all strongly connected because every node is reachable from every other node.

mirror of a strongly connected graph is also a strongly connected graph

so after constructing the mirror graph, you can return any node.

if you construct adjList in one pass and use another pass to reverse -- its 2 passes
we can avoid 2 pass and do it in one pass

so we want to traverse it -- handle the cycles (since its a strongly connected graph) and create the mirror node in one pass

so using dfs to traverse and during backtracking create the edge. <---- edge connection would be in your parent, stack has the edge info and - no need to use adjacency list, visited node is also not needed because while
traversing you are creating your mirror node

    A ---> B --> C > E
    ^           |    v
    |           v    F
    |-----------D <--

TC - all verticies and edges once
SC - number of vertices , stack space and hashmap
 */
class Node
{
    String val;
    Vector<Node> neighbours = new Vector<Node>(0);
    Node(String _val)
    {
        val = _val;
        neighbours.clear();
    }

    public String toString() {

        return "Node: " + this.val ;
    }

};

public class ReverseEdgeDirectedGraph {

    private static Map<Node, Node> map = new HashMap<>();

    private static Node buildreverseGraph(Node node) {
        dfs(node);
        return map.get(node);
    }

    private static void dfs(Node n) {
        Node tmp = new Node(n.val);
        map.put(n, tmp);

        for (Node nbr : n.neighbours) {
            if (!map.containsKey(nbr)) {
                dfs(nbr);
            }
            map.get(nbr).neighbours.add(tmp);
        }
    }





    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        A.neighbours.add(B);
        B.neighbours.add(C);

        C.neighbours.add(D);
        C.neighbours.add(E);

        D.neighbours.add(A);
        E.neighbours.add(F);
        F.neighbours.add(D);

        buildreverseGraph(A);

    }

}
