package com.ds.tree;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		TreeNode current = root;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.empty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode current = stack.pop();
		int result = current.data;
		if (current.right != null) {
			current = current.right;
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
		}
		return result;
	}
}

/**
 * Your BSTIterator will be called like this: 
 * BSTIterator i = new BSTIterator(root); 
 * while (i.hasNext()) 
 * v[f()] = i.next();
 */