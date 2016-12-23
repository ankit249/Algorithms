package com.ds.tree;

public class MaxPathSum {

	private static int maxPathSum(TreeNode node, int sum) {

		if (node == null)
			return 0;

		int leftSum = maxPathSum(node.left, sum);
		int rightSum = maxPathSum(node.right, sum);

		int max = Math.max(node.data, Math.max(node.data + leftSum, node.data + rightSum));
		int result = Math.max(sum, Math.max(max, node.data + leftSum + rightSum));

		return result;

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(3);
		bst.insert(root, 1);
		bst.insert(root, -1);
		bst.insert(root, -2);
		bst.insert(root, 2);
		bst.insert(root, 4);
/*
		TreeNode root = new TreeNode(7);
		bst.insert(root, 5);
		bst.insert(root, 21);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 19);
		bst.insert(root, 23);
		bst.insert(root, 17);
		bst.insert(root, 20);
		bst.insert(root, 22);
		bst.insert(root, 24);
		bst.insert(root, 16);
		bst.insert(root, 18);
*/
		BTreePrinter.printNode(root);

		MaxPathSum mps = new MaxPathSum();
		System.out.println(maxPathSum(root, 0));

		System.out.print(
				"The Sum (might not go thru root just like this example, diameter is no. of nodes in this path): ");
		System.out.println(18 + 17 + 19 + 21 + 23 + 24);
	}
}
