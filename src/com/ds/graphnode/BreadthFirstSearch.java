package com.ds.graphnode;

public class BreadthFirstSearch {

	// from here: http://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/

	public static class GraphNode {
		int data;
		GraphNode next;
		GraphNode[] neighbors;
		boolean visited;

		GraphNode(int data) {
			this.data = data;
		}

		GraphNode(int x, GraphNode[] n) {
			data = x;
			neighbors = n;
		}

		public String toString() {
			return "value: " + this.data;
		}

	}

	private static class Queue {
		GraphNode head, tail;

		public void enqueue(GraphNode n) {
			if (head == null) {
				head = n;
				tail = head;
			} else {
				tail.next = n;
				tail = n;
			}
		}

		public GraphNode dequeue() {
			if (head == null) {
				return null;
			} else {

				// from here: http://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/
				// notice the second parameter in the constructor...
				GraphNode n = new GraphNode(head.data, head.neighbors);
				head = head.next;

				return n;
			}
		}
	}

	/*private static class Stack {
		GraphNode top;

		public void push(GraphNode p) {
			GraphNode n = new GraphNode(p.data, p.neighbors);
			while (top != null) {
				top = top.next;
				top = n;
			}
		}

		public GraphNode pop() {
			if (top == null) {
				return null;
			}

			GraphNode n = new GraphNode(top.data, top.neighbors);
			top = top.next;
			return n;
		}
	}*/

	public static void bfs(GraphNode root, int x) {
		if (root.data == x)
			System.out.println("find in root");

		Queue queue = new Queue();
		root.visited = true;
		queue.enqueue(root);

		while (queue.head != null) {
			GraphNode c = (GraphNode) queue.dequeue();
			for (GraphNode n : c.neighbors) {

				if (!n.visited) {
					System.out.print(n + " ");
					n.visited = true;
					if (n.data == x)
						System.out.println("Find " + n);
					queue.enqueue(n);
				}
			}
		}
	}

	public static void dfs(GraphNode p, int x) {
		p.visited = true;
		for (GraphNode n : p.neighbors) {
			if (!n.visited) {
				System.out.print(n + " ");
				if (n.data == x) {
					System.out.println("Find " + n);
					return;
				}
				dfs(n, x);
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

		System.out.println("bfs***");
		bfs(n1, 5);

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

		System.out.println("dfs***");
		dfs(n1, 4);
	}
}
