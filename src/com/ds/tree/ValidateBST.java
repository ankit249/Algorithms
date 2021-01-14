package com.ds.tree;


public class ValidateBST {

	private static boolean isValidBST(TreeNode root) {

		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean helper(TreeNode node, Integer min, Integer max) {

		if (node == null) {
			return true;
		}

		if (node.data <= min || node.data >= max) {
			return false;
		}
		return helper(node.left, min, node.data) && helper(node.right, node.data, max);

	}


	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(30);
		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 15);
		bst.insert(root, 50);
		bst.insert(root, 40);
		bst.insert(root, 60);


		System.out.println(isValidBST(root));
	}
}
