package com.ds.tree;

import java.util.LinkedList;
import java.util.List;

public class SerializeNAryTree {
	static class Node {
		char c;
		List<Node> list = new LinkedList<Node>();

		public Node(char c) {
			this.c = c;
		}

		public void addChild(Node node) {
			list.add(node);
		}
	}

	public Node deserialize(String str) {
		Node root = deserializeRecursive(str);
		return root;
	}

	private int currentIndex = 0;

	private Node deserializeRecursive(String str) {
		if (currentIndex > str.length() - 1 || str.charAt(currentIndex) == ')') {
			return null;
		}

		Node root = new Node(str.charAt(currentIndex));
		while (currentIndex < str.length()) {
			currentIndex++;
			Node child = deserializeRecursive(str);
			if (child == null)
				break;
			root.addChild(child);

		}
		return root;
	}

	private StringBuffer sb = new StringBuffer();

	public String serialize(Node root) {
		serializeRecursive(root);
		return sb.toString();
	}

	private void serializeRecursive(Node root) {
		if (root == null) {
			return;
		}

		sb.append(root.c);
		for (Node node : root.list) {
			serializeRecursive(node);
		}
		sb.append(')');
	}

	public static void main(String[] args) {
		String str = "ABE)FK)))C)DG)H)I)J)))";
		Node root = new SerializeNAryTree().deserialize(str);
		String str1 = new SerializeNAryTree().serialize(root);
		System.out.println(str1);

		/*
		str = "ABE)FK)))C)DG)))H)I)J)))";
		root = new SerializeNAryTree().deserialize(str);
		str1 = new SerializeNAryTree().serialize(root);
		System.out.println(str1);
		*/
	}

}

