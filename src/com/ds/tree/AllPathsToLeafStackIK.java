package com.ds.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AllPathsToLeafStackIK {

	private static List<List<Integer>> findPaths(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		helper(root, new Stack<Integer>(), result);
		return result;
	}

	private static void helper(TreeNode node, Stack<Integer> slate, List<List<Integer>> result) {
		slate.add(node.data);
		// base case
		// leaf node
		if(node.left == null && node.right == null) {
			List<Integer> list = new ArrayList<>(slate);
			result.add(list);
			slate.pop();
			return;
		}

		// recursion
		if(node.left != null) {
			helper(node.left, slate, result);
		}
		if(node.right != null) {
			helper(node.right, slate, result);
		}
		slate.pop();
		return;
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

		List<List<Integer>> results = findPaths(root);
		System.out.println(results);
	}
}
