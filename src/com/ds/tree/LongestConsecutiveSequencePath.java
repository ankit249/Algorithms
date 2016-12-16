package com.ds.tree;

/*
Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
For example,
   1
    \\
     3
    / \\
   2   4
        \\
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \\
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
Tags:Tree
Similar Problems: (H) Longest Consecutive Sequence
*/
public class LongestConsecutiveSequencePath {


	public int longestConsecutivePath(TreeNode root) {
		return helper(root, null, 0);
	}

	public int helper(TreeNode current, TreeNode parent, int depth) {
		if (current == null) {
			return 0;
		}
		int currDepth = 0;
		if (parent != null && parent.data + 1 == current.data) {
			currDepth = depth + 1;
		} else {
			currDepth = 1;
		}
		return Math.max(currDepth,
				Math.max(helper(current.left, current, currDepth), helper(current.right, current, currDepth)));
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(7);
		bst.insert(root, 5);
		bst.insert(root, 8);
		bst.insert(root, 9);
		bst.insert(root, 10);
		bst.insert(root, 4);
		bst.insert(root, 6);

		BTreePrinter.printNode(root);

		LongestConsecutiveSequencePath lps = new LongestConsecutiveSequencePath();

		System.out.println(lps.longestConsecutivePath(root));

	}
}
