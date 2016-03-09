package com.ds.tree;

public class MirrorTree {

	public static void mirror(TreeNode root) {
		if (root == null)
			return;
		mirror(root.left);
		mirror(root.right);

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(4);
		bst.insert(root, 2);
		bst.insert(root, 6);
		bst.insert(root, 1);
		bst.insert(root, 3);
		bst.insert(root, 5);
		bst.insert(root, 7);
		bst.insert(root, 8);

		// original tree
		BTreePrinter.printNode(root);

		mirror(root);

		System.out.println("mirror tree: ");
		BTreePrinter.printNode(root);
	}
}
