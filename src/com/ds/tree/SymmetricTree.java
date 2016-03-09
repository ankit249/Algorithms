package com.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	private boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode n = q.poll();

			if (n.left != null) {
				q.offer(n.left);
			}
			if (n.right != null) {
				q.offer(n.right);
			}

			if (n.left == null && n.right == null)
				break;

			if (n.left == null)
				return false;
			if (n.right == null)
				return false;

			if (n.left.data != n.right.data)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.right = new TreeNode(10);


		BTreePrinter.printNode(root);

		System.out.println(new SymmetricTree().isSymmetric(root));


	}
}
