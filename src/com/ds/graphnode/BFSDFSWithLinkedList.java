package com.ds.graphnode;

import java.util.LinkedList;

// instead of having to use and construct Queue, use LinkedList for Queue for bfs
// bfs is always done with Queue and dfs is always with recursion (no need for additional DS)
public class BFSDFSWithLinkedList {

	static class GraphNode {
		int data;
		GraphNode neighbors[];
		boolean visited;

		GraphNode(int data) {
			this.data = data;
		}

		GraphNode(int data, GraphNode[] n) {
			this.data = data;
			this.neighbors = n;
		}

		public String toString() {
			return "value: " + this.data;
		}
	}

	public static void bfs(GraphNode root, int value) {
		java.util.Queue<GraphNode> queue = new LinkedList<GraphNode>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			GraphNode e = queue.poll();
			e.visited = true;
			if (e.data == value) {
				System.out.println("Find value: " + e.data);
				return;
			}

			for (GraphNode n : e.neighbors) {
				if (!n.visited) {
					System.out.print("value: " + n.data);
					n.visited = true;
					queue.offer(n);
				}
			}

		}
	}

	public static void dfs(GraphNode current, int value) {
		current.visited = true;
		for (GraphNode e : current.neighbors) {
			if (e.data == value) {
				System.out.println("Find value: " + e.data);
				return;
			}

			if (!e.visited) {
				System.out.print("value: " + e.data);
				dfs(e, value);
			}
		}
	}

	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		n1.neighbors = new GraphNode[] { n2, n3, n5 };
		n2.neighbors = new GraphNode[] { n1, n4 };
		n3.neighbors = new GraphNode[] { n1, n4, n5 };
		n4.neighbors = new GraphNode[] { n2, n3, n5 };
		n5.neighbors = new GraphNode[] { n1, n3, n4 };

		System.out.println("***bfs***");
		bfs(n1, 5);
		// bfs(n1, 1);
		System.out.println("_________________");

		n1 = new GraphNode(1);
		n2 = new GraphNode(2);
		n3 = new GraphNode(3);
		n4 = new GraphNode(4);
		n5 = new GraphNode(5);
		n1.neighbors = new GraphNode[] { n2, n3, n5 };
		n2.neighbors = new GraphNode[] { n1, n4 };
		n3.neighbors = new GraphNode[] { n1, n4, n5 };
		n4.neighbors = new GraphNode[] { n2, n3, n5 };
		n5.neighbors = new GraphNode[] { n1, n3, n4 };

		System.out.println("***dfs***");
		dfs(n1, 5);

	}
}
