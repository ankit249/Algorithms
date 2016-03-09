package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsToLeafArrayList {

	private static void findPaths(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		findPaths(root, list);
	}

	private static void findPaths(TreeNode root, List<Integer> list) {
		if (root == null)
			return;

		list.add(root.data);

		if (root.left == null && root.right == null) {
			printPaths(list);
		} else {
			findPaths(root.left, list);
			findPaths(root.right, list);
		}

		list.remove(list.size() - 1);
	}

	private static void printPaths(List<Integer> list) {
		for (Integer l : list) {
			System.out.print(l + " ");
		}
		System.out.println();
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
		bst.insert(root, 70);
		bst.insert(root, 80);

		BTreePrinter.printNode(root);

		findPaths(root);
	}
}
