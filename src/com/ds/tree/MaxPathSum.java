package com.ds.tree;

public class MaxPathSum {

	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);

		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
		max[0] = Math.max(max[0], Math.max(current, left + root.data + right));

		return current;
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
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

		BTreePrinter.printNode(root);

		MaxPathSum mps = new MaxPathSum();
		System.out.println(mps.maxPathSum(root));

		System.out.print(
				"The Sum (might not go thru root just like this example, diameter is no. of nodes in this path): ");
		System.out.println(18 + 17 + 19 + 21 + 23 + 24);
	}
}
