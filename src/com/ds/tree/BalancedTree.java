package com.ds.tree;

// look at the BinarySearchTree.java first.
public class BalancedTree {

	
	public static boolean isBalanced(TreeNode root) {
		return (maxdepth(root) - mindepth(root) < 2);
	}

	private static int maxdepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxdepth(root.left), maxdepth(root.right));
	}

	private static int mindepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(mindepth(root.left), mindepth(root.right));
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(30);
		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 50);
		bst.insert(root, 40);
		bst.insert(root, 60);

		System.out.println(isBalanced(root));

	}

}
