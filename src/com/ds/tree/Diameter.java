package com.ds.tree;

class Height {
	int h;
}

public class Diameter {

	public static int diameterOfBinaryTree(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = maxdepth(node.left);
		int rightHeight = maxdepth(node.right);

		int leftDiameter = diameterOfBinaryTree(node.left);
		int rightDiameter = diameterOfBinaryTree(node.right);

		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
	}

	private static int maxdepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxdepth(root.left), maxdepth(root.right));
	}

	/*
	 * define height =0 globally and call diameter(root,height) from main
	 */
	// This method result is incorrect
	int diameter(TreeNode root, Height currentHeight) {
		if (root == null) {
			currentHeight.h = 0;
			return 0; /* diameter is also 0 */
		}

		Height leftHeight = new Height();
		Height rightHeight = new Height();


		/*
		 * ldiameter --> diameter of left subtree rdiameter --> Diameter of right subtree
		 */
		/*
		 * Get the heights of left and right subtrees in leftHeight and rightHeight And store the returned values in
		 * ldiameter and ldiameter
		 */
		leftHeight.h++;
		rightHeight.h++;

		/*
		 * Height of current node is max of heights of left and right subtrees plus 1
		 */
		currentHeight.h = Math.max(leftHeight.h, rightHeight.h) + 1;

		int ldiameter = diameter(root.left, leftHeight);
		int rdiameter = diameter(root.right, rightHeight);

		return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(ldiameter, rdiameter));
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		
		
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(40);
		bst.insert(root, 20);
		bst.insert(root, 10);
		bst.insert(root, 1);
		bst.insert(root, 2);
		bst.insert(root, 3);
		bst.insert(root, 30);
		bst.insert(root, 35);
		bst.insert(root, 32);
		bst.insert(root, 33);
		bst.insert(root, 50);
		
		
		/*
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(3);
		bst.insert(root, 1);
		bst.insert(root, -1);
		bst.insert(root, -2);
		bst.insert(root, 2);
		bst.insert(root, 4);
		*/
		// original tree
		BTreePrinter.printNode(root);

		Diameter d = new Diameter();
		Height height = new Height();

		System.out.println("The diameter of given binary tree is (Method 1) : " + d.diameter(root, height));
		System.out.println("The diameter of given binary tree is (Method 2: Correct): " + diameterOfBinaryTree(root));

	}
}
