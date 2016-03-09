package com.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MNode {
	int data;
	List<MNode> list;

	MNode(int data, List<MNode> list) {
		this.data = data;
		this.list = list;
	}

	MNode(int data) {
		this.data = data;
		this.list = null;
	}

	@Override
	public String toString() {
		return "MNode [data=" + data + ", list=" + list + "]";
	}

}

public class NonBinaryTree {

	private static int maxdepth(MNode root) {
		if (root == null) { // if its a leaf
			return 0;
		} else {
			int maxdepth = 0;
			if (root.list != null) {
				for (MNode m : root.list) {
					maxdepth = Math.max(maxdepth, maxdepth(m));
				}
			}
			return maxdepth + 1;
		}
	}


	private static void dfsTraversal(MNode root) {

		if (root.list == null) {
			System.out.print(root.data + " ");
			return;
		}

		for (MNode m : root.list) {
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

		root.list.add(two);
		root.list.add(three);
		root.list.add(four);
		root.list.add(five);

		// System.out.println(root);

		dfsTraversal(root);
		System.out.println();
		System.out.println("max height of the tree: " + maxdepth(root));
	}
}
