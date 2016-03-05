package com.ds.tree;

class Node {
	Node parent;
	Node left;
	Node right;

	Node(Node l, Node r, Node p) {
		left = l;
		right = r;
		parent = p;
	}
}

public class LowestCommonAncestorWithParent {

	int getHeight(Node n) {
		int h = 0;
		while (n != null) {
			n = n.parent;
			h++;
		}
		return h;
	}

	Node getLowestParent(Node n1, Node n2) {
		Node tmp = n1;
		int s1 = getHeight(tmp);
		tmp = n2;
		int s2 = getHeight(tmp);

		if (s2 > s1) {
			int count = s2 - s1;
			for (int i = 0; i < count; i++) {
				n2 = n2.parent;
			}
		}

		if (s1 > s2) {
			int count = s1 - s2;
			for (int i = 0; i < count; i++) {
				n1 = n1.parent;
			}
		}

		Node curr1 = n1;
		Node curr2 = n2;

		while (curr1 != null || curr2 != null) {
			if (curr1 == curr2) {
				return curr1;
			}
			curr1 = curr1.parent;
			curr2 = curr2.parent;

		}
		return null;

	}

}
