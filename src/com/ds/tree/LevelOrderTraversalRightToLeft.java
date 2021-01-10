package com.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// it is like BFS so use queue's here 2 queues
// TC: O(n)
// SC: finalresult - n, templist - n /2 equivalend to O(n)
public class LevelOrderTraversalRightToLeft {
	public List<List<Integer>> levelOrderTraversal(TreeNode root) {

		List<List<Integer>> finalList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		Queue<TreeNode> currentQueue = new LinkedList<>();
		Queue<TreeNode> nextQueue = new LinkedList<>();

		if (root == null) {
			return finalList;
		}
		
		currentQueue.offer(root);
		while (!currentQueue.isEmpty()) {
			TreeNode n = currentQueue.poll();
			list.add(n.data);

			// right first
			if (n.right != null) {
				nextQueue.offer(n.right);
			}

			if (n.left != null) {
				nextQueue.offer(n.left);
			}

			if (currentQueue.isEmpty()) {
				currentQueue = nextQueue;
				finalList.add(list);
				list = new ArrayList<>();
				nextQueue = new LinkedList<>();
			}
		}

		return finalList;
	}




	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(30);
		bst.insert(root, 20);
		bst.insert(root, 25);
		bst.insert(root, 15);
		bst.insert(root, 50);
		bst.insert(root, 40);
		bst.insert(root, 60);

		BTreePrinter.printNode(root);

		LevelOrderTraversalRightToLeft lt = new LevelOrderTraversalRightToLeft();
		System.out.println(lt.levelOrderTraversal(root));

	}
}
