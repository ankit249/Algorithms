package com.ds.graphnode;

public class Queue {
	GraphNode head, last;

	public void enqueue(GraphNode n) {
		if (head == null) {
			head = n;
			last = head;
		} else {
			last.next = n;
			last = n;
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
