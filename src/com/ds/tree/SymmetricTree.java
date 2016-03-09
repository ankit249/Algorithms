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
	
	public boolean isSymmetricRecursive(TreeNode root) {
		if(root == null) return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null && root.right != null) {
			return (root.left.data == root.right.data) &&
					isSymmetricRecursive(root.left) && isSymmetricRecursive(root.right);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(40);
		root.right.right = new TreeNode(40);

		BTreePrinter.printNode(root);

		System.out.println(new SymmetricTree().isSymmetric(root));
		System.out.println(new SymmetricTree().isSymmetricRecursive(root));

	}
}
