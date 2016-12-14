package com.ds.tree;

// without using additiona Data structre
public class LevelOrderTraversal2 {
	public static void PrintLevelNodes(TreeNode root, int level) {
		if (level == 0) {
			System.out.print(root.data + " ");
			return;
		}

		if (root.left != null) {
			PrintLevelNodes(root.left, level - 1);
		}

		if (root.right != null) {
			PrintLevelNodes(root.right, level - 1);
		}
	}

	private static int maxdepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxdepth(root.left), maxdepth(root.right));
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

		BTreePrinter.printNode(root);

		int depth = maxdepth(root);
		for (int i = 0; i < depth; i++) {
			PrintLevelNodes(root, i);
			System.out.println();
		}
	}

}
