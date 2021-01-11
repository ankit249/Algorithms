package com.ds.tree;
/*

/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */



public class ConvertSortedArrayToBST {

	public static void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	public static TreeNode sortedArrayToBST(int[] a, int lo, int hi) {

		if (lo > hi)
			return null;

		int mid = lo + (hi - lo) / 2;   // avoid the overflow
		// find root
		TreeNode root = new TreeNode(a[mid]);
		root.left = sortedArrayToBST(a, lo, mid - 1);
		root.right = sortedArrayToBST(a, mid + 1, hi);

		return root;
	}

	public static void main(String[] args) {
		//int[] a = new int[] { 10, 15, 20, 25, 30 };
		int[] a = new int[] { -10, -3, 0, 5, 9 };
		TreeNode root = sortedArrayToBST(a, 0, a.length - 1);
		BTreePrinter.printNode(root);

		inorderTraversal(root);

	}
}