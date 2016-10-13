package com.ds.tree;

//Java program to convert a given Binary Tree to 
//Doubly Linked List

/* Structure for tree and Linked List */


public class ConvertTreeToDoublyLinkList {
	// 'root' - root of binary tree
	TreeNode root;

	// 'head' - reference to head node of created
	// double linked list
	TreeNode head;

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	void BToDLL(TreeNode root) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			(head).left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.left);
	}

	// Utility function for printing double linked list.
	void printList(TreeNode head) {
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	// Driver program to test the above functions
	public static void main(String[] args) {


		TreeNode root = new TreeNode(30);
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 50);
		bst.insert(root, 40);
		bst.insert(root, 60);

		// should give you sorted in ascending order
		BTreePrinter.printNode(root);

		ConvertTreeToDoublyLinkList c = new ConvertTreeToDoublyLinkList();

		c.BToDLL(root);
		c.printList(c.head);
	}
}

// This code has been contributed by Mayank Jaiswal(mayank_24)
