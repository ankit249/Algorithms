package com.ds.tree;

// Find deepest node in the binary tree
public class DeepestNodeInBTree {

	int deepestlevel;
	int deepestnodedata;

	private void findDfs(TreeNode root) {
		findDfs(root, 0);
		System.out.println("Node data: " + deepestnodedata + " at level: " + deepestlevel);
	}

	// like inorder traversal
	private void findDfs(TreeNode root, int level) {
		if (root != null) {
			findDfs(root.left, ++level);

			if (deepestlevel < level) {
				deepestlevel = level;
				deepestnodedata = root.data;
			}

			findDfs(root.right, level);
		}

	}
/*
	private void findBfs(TreeNode root) {
		int currrent_level = 0;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root);
		currrent_level++;
		while (!q1.isEmpty()) {
			TreeNode n = q1.poll();

			if (n.left != null) {
				q2.add(n.left);
			}

			if (n.left != null) {
				q2.add(n.right);
			}

			if (q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
				currrent_level++;
				deepestlevel = currrent_level;
				deepestnodedata = q1.peek().data;

			}
		}

		System.out.println("Node data: " + deepestnodedata + " at level: " + deepestlevel);

	}
*/
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(30);
		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 15);
		bst.insert(root, 50);
		bst.insert(root, 40);
		bst.insert(root, 60);
		bst.insert(root, 35);
		bst.insert(root, 70);
		bst.insert(root, 80);
		bst.insert(root, 90);

		BTreePrinter.printNode(root);

		DeepestNodeInBTree d = new DeepestNodeInBTree();
		d.findDfs(root);

		//d.findBfs(root);
	}
}
