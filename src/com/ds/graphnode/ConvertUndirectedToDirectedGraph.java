package com.ds.graphnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class GNode {
	boolean visited;
	GNode[] neighbors;
	int data;

	// int visitcount = 0;

	GNode(int data) {
		this.data = data;
	}

	GNode(int data, GNode[] neighbors) {
		this.neighbors = neighbors;
		this.data = data;
	}

	public String toString() {
		return "value: " + this.data;
	}
}

// not working, logic is not right so dont do this

// use topological sort instead and once you get the result use the arrows from right to left direction which will give
// you a directed graph.
public class ConvertUndirectedToDirectedGraph {

	static Map<GNode, ArrayList<GNode>> edgeMap = new HashMap<GNode, ArrayList<GNode>>();

	public void bfs(GNode root) {
		GNode current = root;
		java.util.Queue<GNode> q = new LinkedList<GNode>();
		q.offer(current);

		while (!q.isEmpty()) {
			GNode e = q.poll();
			for (GNode n : e.neighbors) {
				if (!n.visited) {
					if (edgeMap.get(e) != null) {
						edgeMap.get(e).add(n);
					} else {
						ArrayList<GNode> list = new ArrayList<GNode>();
						list.add(n);
						edgeMap.put(e, list);
					}
					q.offer(n);
					//n.visitcount++;
					n.visited = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		GNode n1 = new GNode(1);
		GNode n2 = new GNode(2);
		GNode n3 = new GNode(3);
		GNode n4 = new GNode(4);
		GNode n5 = new GNode(5);
		n1.neighbors = new GNode[] { n2, n3, n5 };
		n2.neighbors = new GNode[] { n1, n4 };
		n3.neighbors = new GNode[] { n1, n4, n5 };
		n4.neighbors = new GNode[] { n2, n3, n5 };
		n5.neighbors = new GNode[] { n1, n3, n4 };

		ConvertUndirectedToDirectedGraph a = new ConvertUndirectedToDirectedGraph();
		// a.dfs(n1);
		a.bfs(n1);
		System.out.println(edgeMap);
	}
}
