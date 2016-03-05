package com.ds.tree;


public class ValidateBST {

	private boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, Integer min, Integer max) {

		if (root == null)
			return true;
		if (root.data <= min || root.data >= max) {
			return false;
		}
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);

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

		ValidateBST lt = new ValidateBST();
		System.out.println(lt.isValidBST(root));
	}
}
