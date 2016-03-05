package com.ds.tree;

import java.util.Stack;

public class FlattenBinaryTree {

	public void flattenTreeToRight(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (current != null || !stack.empty()) {

			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				current.right = current.left;
				current.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				current.right = temp;
			}

			current = current.right;
		}
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

		BTreePrinter.printNode(root);

		FlattenBinaryTree fbt = new FlattenBinaryTree();
		fbt.flattenTreeToRight(root);// this will do in place flattening
		BTreePrinter.printNode(root);

	}

}
