package com.ds.tree;

// this is the lowest common ancestor of a binary tree and not binary search tree
// https://www.youtube.com/watch?v=13m9ZCB8gjw&ab_channel=TusharRoy-CodingMadeSimple
/*

   1
  / \
 /   \
 2   3
/ \ / \
4 5 6 7



 */

public class LcaBinaryTree {

	TreeNode findLCA(TreeNode root, int n1, int n2) {
		if(root == null) { return null; }
		if(root.data == n1 || root.data == n2) { return root; }
		TreeNode left = findLCA(root.left, n1, n2);
		TreeNode right = findLCA(root.right, n1, n2);

		if(left != null && right != null) return root;
		if(left == null && right == null) return null;

		return left != null ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		BTreePrinter.printNode(root);

		LcaBinaryTree lca = new LcaBinaryTree();
		System.out.println("lca(6 , 7): " + lca.findLCA(root, 6, 7).data);
		System.out.println("lca(4 , 5): " + lca.findLCA(root, 4, 5).data);
		System.out.println("lca(2 , 3): " + lca.findLCA(root, 2, 3).data);
		System.out.println("lca(4 , 3): " + lca.findLCA(root, 4, 3).data);
	}
}
