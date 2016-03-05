package com.ds.graphnode;


public class GraphNode {
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
