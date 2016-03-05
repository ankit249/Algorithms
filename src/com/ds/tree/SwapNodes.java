package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

//or invert
public class SwapNodes {

	private void swap(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		TreeNode tmp = null;

		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();

			if (n.left != null) {
				queue.offer(n.left);
			}
			if (n.right != null) {
				queue.offer(n.right);
			}

			tmp = n.left;
			n.left = n.right;
			n.right = tmp;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(30);
		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 15);
		bst.insert(root, 50);
		// bst.insert(root, 40);
		bst.insert(root, 60);

		System.out.println("before swap:");
		BTreePrinter.printNode(root);

		SwapNodes obj = new SwapNodes();
		obj.swap(root);
		System.out.println("after swap:");
		BTreePrinter.printNode(root);

	}
}
