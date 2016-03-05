package com.ds.graphnode;

public class Queue {
	GraphNode first, last;

	public void enqueue(GraphNode n) {
		if (first == null) {
			first = n;
			last = first;
		} else {
			last.next = n;
			last = n;
		}
	}

	public GraphNode dequeue() {
		if (first == null) {
			return null;
		} else {

			// from here: http://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/
			// notice the second parameter in the constructor...
			GraphNode n = new GraphNode(first.data, first.neighbors);
			first = first.next;

			return n;
		}
	}
}
