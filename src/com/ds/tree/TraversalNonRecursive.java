package com.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalNonRecursive {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode n = stack.pop();
			result.add(n.data);

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}

		}
		return result;
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				TreeNode pop = stack.pop();
				res.add(pop.data);
			} else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}
				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
				}
			}
		}
		return res;
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (!stack.empty() || current != null) {

			if (current != null) {
				stack.push(current);
				current = current.left;

			} else {
				TreeNode n = stack.pop();
				result.add(n.data);
				current = n.right;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		/*
		TreeNode root = new TreeNode(4);
		bst.insert(root, 2);
		bst.insert(root, 5);
		bst.insert(root, 0);
		bst.insert(root, 3);
		bst.insert(root, 1);
		*/
		TreeNode root = new TreeNode(30);
		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 50);
		bst.insert(root, 40);
		bst.insert(root, 60);
		bst.insert(root, 15);

		BTreePrinter.printNode(root);

		System.out.println("Preorder Traversal: " + preorderTraversal(root));
		System.out.println("Inorder Traversal: " + inorderTraversal(root));
		System.out.println("Postorder Traversal: " + postorderTraversal(root));

	}
}
