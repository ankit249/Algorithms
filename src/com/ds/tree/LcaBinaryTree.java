package com.ds.tree;

// this is the lowest common ancestor of a binary tree and not binary search tree
public class LcaBinaryTree {

	// This function returns pointer to LCA of two given
	// values n1 and n2. This function assumes that n1 and
	// n2 are present in Binary Tree
	TreeNode findLCA(TreeNode root, int n1, int n2) {
		// Base case
		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.data == n1 || root.data == n2)
			return root;

		// Look for keys in left and right subtrees
		TreeNode left_lca = findLCA(root.left, n1, n2);
		TreeNode right_lca = findLCA(root.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return root;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
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
	}
}
