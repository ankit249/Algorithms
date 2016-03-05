package com.ds.tree;

public class ConvertToBST {

	public void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	public TreeNode sortedArrayToBST(int[] a, int lo, int hi) {
		if (lo > hi)
			return null;
		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(a[mid]);
		root.left = sortedArrayToBST(a, lo, mid - 1);
		root.right = sortedArrayToBST(a, mid + 1, hi);

		return root;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 10, 15, 20, 25, 30 };
		ConvertToBST obj = new ConvertToBST();

		obj.inorderTraversal(obj.sortedArrayToBST(a, 0, a.length - 1));

	}
}