package com.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TODO

// it is like BFS so use queue's here 2 queues
// TC: O(n)
// SC: finalresult - n, templist - n /2 equivalend to O(n)

class NaryTreeNode {
	int data;
	List<NaryTreeNode> nextQueue;

	public NaryTreeNode(int data) {
		this.data = data;
		nextQueue = new ArrayList<NaryTreeNode>();
	}
}

public class LevelOrderTraversalNAry {
	public List<List<Integer>> levelOrderTraversal(NaryTreeNode root) {

		List<List<Integer>> finalList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		Queue<NaryTreeNode> currentQueue = new LinkedList<>();
		Queue<NaryTreeNode> nextQueue = new LinkedList<>();

		if (root == null) {
			return finalList;
		}
		
		currentQueue.offer(root);
		while (!currentQueue.isEmpty()) {
			NaryTreeNode n = currentQueue.poll();
			list.add(n.data);

			for(NaryTreeNode child : n.nextQueue) {
				nextQueue.offer(child);
			}

			if (currentQueue.isEmpty()) {
				currentQueue = nextQueue;
				finalList.add(list);
				list = new ArrayList<>();
				nextQueue = new LinkedList<>();
			}
		}

		return finalList;
	}



	public static void main(String[] args) {

		NaryTreeNode root = new NaryTreeNode(30);

	}
}
