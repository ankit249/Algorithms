package com.ds.tree;

import java.util.StringTokenizer;

public class SerializeBST {

	StringBuilder sb = new StringBuilder();

	private void serialize(TreeNode root) {
		if (root == null) {
			sb.append("# ");
		} else {
			sb.append(root.data + " ");
			serialize(root.left);
			serialize(root.right);
		}
	}

	private TreeNode deserialize(StringTokenizer st) {
		if (!st.hasMoreTokens()) return null;
		String data = st.nextToken();
		if (data.equals("#")) return null;
		
		TreeNode root = new TreeNode(Integer.parseInt(data));
		root.left = deserialize(st);
		root.right = deserialize(st);
		return root;
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(4);
		bst.insert(root, 2);
		bst.insert(root, 6);
		bst.insert(root, 1);
		bst.insert(root, 3);
		bst.insert(root, 5);
		bst.insert(root, 7);
		bst.insert(root, 8);

		// original tree
		BTreePrinter.printNode(root);

		SerializeBST object = new SerializeBST();
		object.serialize(root);
		String result = object.sb.toString();
		System.out.println(result);

		StringTokenizer st = new StringTokenizer(result, " ");
		TreeNode node = object.deserialize(st);
		// deserialized tree
		BTreePrinter.printNode(node);
	}


}
