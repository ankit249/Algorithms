package com.ds.tree;

/*
  
 Changes the tree by inserting a duplicate node 
 on each nodes's .left. 
  
 
 So the tree... 
    2 
   / \ 
  1   3

 Is changed to... 
       2 
      / \ 
     2   3 
    /   / 
   1   3 
  / 
 1

 Uses a recursive helper to recur over the tree 
 and insert the duplicates. 
 
 
*/
public class DoubleTree {

	private static void doubletree(TreeNode root) {
		if (root == null)
			return;

		doubletree(root.left);
		doubletree(root.right);

		TreeNode old = root.left;
		root.left = new TreeNode(root.data);
		root.left.left = old;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(2);
		bst.insert(root, 1);
		bst.insert(root, 3);

		// original tree
		BTreePrinter.printNode(root);

		doubletree(root);
		System.out.println("double tree");
		// double tree
		BTreePrinter.printNode(root);
	}

}
