package com.ds.tree;

//https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/
//The problem can be solved by divide-and-conquer. The only trick is to use different return values to mark different cases. 
//Integer.MIN_VALUE -- Mark the subtree is not univaled. 
//Integer.MAX_VALUE -- Mark if the root is null. 
public class UnivalTree {

	private int count = 0;

	public boolean isUnivalSubtree(TreeNode root) {
		if (root == null) return true;
		return isUnivalSubtreeHelper(root, root.data);
	}

	public boolean isUnivalSubtreeHelper(TreeNode root, int value) {
		if (root == null) return true;
		if (root.data != value) return false;
		return isUnivalSubtreeHelper(root.left, value) && isUnivalSubtreeHelper(root.right, value);
	}

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}

		countUnivalSubtreesHelper(root);

		return count;
	}

	private int countUnivalSubtreesHelper(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		// Divide
		int left = countUnivalSubtreesHelper(root.left);
		int right = countUnivalSubtreesHelper(root.right);

		// left and right are all empty
		if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
			count++;
			return root.data;
		} else if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) {
			if (root.data == left || root.data == right) {
				count++;
				return root.data;
			} else {
				return Integer.MIN_VALUE;
			}
		} else {
			if (root.data == left && root.data == right) {
				count++;
				return root.data;
			} else {
				return Integer.MIN_VALUE;
			}
		}
	}

	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);

		// original tree
		BTreePrinter.printNode(root);

		UnivalTree o = new UnivalTree();
		System.out.println(o.countUnivalSubtrees(root));
		System.out.println(o.isUnivalSubtree(root));

		root = new TreeNode(5);

		root.left = new TreeNode(5);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);

		// original tree
		BTreePrinter.printNode(root);

		o = new UnivalTree();
		System.out.println(o.countUnivalSubtrees(root));
		System.out.println(o.isUnivalSubtree(root));

	}
}
