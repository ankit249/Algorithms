package com.ds.tree;

public class AllPathsToLeaf {

	public static void printPaths(TreeNode root) {
		int[] arr = new int[100]; // if the max depth is 100
		printPaths(root, arr, 0);
	}

	public static void printPaths(TreeNode root, int[] a, int depth) {
		if (root == null)
			return;

		a[depth] = root.data;
		depth = depth + 1;

		if (root.left == null && root.right == null) {
			printArray(a, depth);
		} else {
			printPaths(root.left, a, depth);
			printPaths(root.right, a, depth);
		}
	}

	private static void printArray(int[] a, int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
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

		BTreePrinter.printNode(root);

		printPaths(root);

	}
}
