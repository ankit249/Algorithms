package com.ds.tree;

class Height {
	int h;
}

public class Diameter {


	/*
	 * define height =0 globally and call diameter(root,height) from main
	 */
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
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(20);
		root.left.right.right = new TreeNode(70);

		// original tree
		BTreePrinter.printNode(root);

		Diameter d = new Diameter();
		Height height = new Height();

		System.out.println("The diameter of given binary tree is : " + d.diameter(root, height));
	}
}
