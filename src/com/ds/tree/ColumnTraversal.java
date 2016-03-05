package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

class TNode {
	public TNode left;
	public TNode right;
	public int index;
	public int data;

	TNode(int data) {
		this.data = data;
	}
}

public class ColumnTraversal {

	private int minLeft = 0;
	private int maxRight = 0;

	public void showTree(TNode root) {
		// set index to all node in tree
		// and save left most and right most index
		// note that index may be negative
		root.index = 0;
		setIndex(root);

		// from left most to right most index
		// we using bfs to go through the tree
		// if a node index have same index,
		// print this node's value
		for (int i = minLeft; i <= maxRight; i++) {
			// we init a queue
			Queue<TNode> queue = new LinkedList<TNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TNode e = queue.poll();
				if (e.index == i) {
					System.out.print(e.data + " ");
				}
				if (e.left != null) {
					queue.add(e.left);
				}
				if (e.right != null) {
					queue.add(e.right);
				}
			}
		}
	}

	private void setIndex(TNode current) {
		minLeft = Math.min(minLeft, current.index);
		maxRight = Math.max(maxRight, current.index);

		// left node's index = father's index - 1
		if (current.left != null) {
			current.left.index = current.index - 1;
			setIndex(current.left);
		}

		// right node's index = father's index + 1
		if (current.right != null) {
			current.right.index = current.index + 1;
			setIndex(current.right);
		}
	}

	public static void main(String[] args) {

		ColumnTraversal c = new ColumnTraversal();
		TNode root = new TNode(30);

		c.insert(root, 20);
		c.insert(root, 25);
		c.insert(root, 50);
		c.insert(root, 40);
		c.insert(root, 60);

		c.showTree(root);
	}

	public void insert(TNode root, int data) {
		TNode n = new TNode(data);

		if (root == null) {
			root = n;
		} else {
			TNode current = root;
			TNode parent = null;
			while (true) {
				parent = current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = n;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = n;
						return;
					}
				}
			}
		}
	}

}