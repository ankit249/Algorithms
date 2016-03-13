package com.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MNode {
	int data;
	List<MNode> children;

	MNode(int data, List<MNode> children) {
		this.data = data;
		this.children = children;
	}

	MNode(int data) {
		this.data = data;
		this.children = null;
	}

	@Override
	public String toString() {
		return "MNode [data=" + data + ", children=" + children + "]";
	}

}

public class NonBinaryTree {

	private static int maxdepth(MNode root) {
		if (root == null) { // if its a leaf
			return 0;
		} else {
			int maxdepth = 0;
			if (root.children != null) {
				for (MNode m : root.children) {
					maxdepth = Math.max(maxdepth, maxdepth(m));
				}
			}

			// System.out.println(root.data); // first time the pointer comes here thats the deepest node
			return maxdepth + 1;
		}
	}


	private static void dfsTraversal(MNode root) {

		if (root.children == null) {
			System.out.print(root.data + " ");
			return;
		}

		for (MNode m : root.children) {
			dfsTraversal(m);
		}

		System.out.print(root.data + " ");
	}


	//            1
	//           / \
	//         / / \ \
	//        2 3   4 5
	//       /
	//     100
	//
	public static void main(String[] args) {

		MNode root = new MNode(1, new ArrayList<MNode>());
		MNode hundred = new MNode(100);
		MNode two = new MNode(2, new ArrayList<MNode>(Arrays.asList(hundred)));
		MNode three = new MNode(3);
		MNode four = new MNode(4);
		MNode five = new MNode(5);

		root.children.add(two);
		root.children.add(three);
		root.children.add(four);
		root.children.add(five);

		// System.out.println(root);

		dfsTraversal(root);
		System.out.println();
		System.out.println("max height of the tree: " + maxdepth(root));
	}
}
