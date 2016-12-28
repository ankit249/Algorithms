package com.ds.tree;

public class SumRootToLeaf {

	public static int dfs(TreeNode root) {
		return dfs(root, 0, 0);
	}

	public static int dfs(TreeNode root, int sum, int val) {
		if (root == null) {
			return sum;
		}
		val = val * 10 + root.data;

		if (root.left == null && root.right == null) {
			sum = sum + val;
			return sum;
		} else {
			sum = dfs(root.left, sum, val) + dfs(root.right, sum, val);
			return sum;
		}

	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(4);
		bst.insert(root, 2);
		bst.insert(root, 6);
		bst.insert(root, 1);

		BTreePrinter.printNode(root);

		System.out.println(dfs(root));
	}
}
