package com.ds.graphnode;

public class Queue {
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
