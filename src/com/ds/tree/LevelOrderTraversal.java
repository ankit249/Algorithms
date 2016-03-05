package com.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// it is like BFS so use queue's here 2 queues
public class LevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Queue<TreeNode> currentQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();

		if (root == null) {
			return finalList;
		}
		
		currentQueue.offer(root);
		while (!currentQueue.isEmpty()) {
			TreeNode n = currentQueue.poll();
			list.add(n.data);

			if (n.left != null) {
				nextQueue.offer(n.left);
			}

			if (n.right != null) {
				nextQueue.offer(n.right);
			}

			if (currentQueue.isEmpty()) {
				currentQueue = nextQueue;
				finalList.add(list);
				list = new ArrayList<Integer>();
				nextQueue = new LinkedList<TreeNode>();
			}
		}

		return finalList;
	}

	public void levelOrderTraversal_1(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> currentQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();

		if (root == null) {
			System.out.println(sb.toString());
			return;
		}

		currentQueue.offer(root);
		while (!currentQueue.isEmpty()) {
			TreeNode n = currentQueue.poll();
			sb.append(n.data + " ");

			if (n.left != null) {
				nextQueue.offer(n.left);
			}

			if (n.right != null) {
				nextQueue.offer(n.right);
			}

			if (currentQueue.isEmpty()) {
				currentQueue = nextQueue;
				System.out.println(sb.toString());
				sb = new StringBuilder();
				nextQueue = new LinkedList<TreeNode>();
			}
		}

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

		LevelOrderTraversal lt = new LevelOrderTraversal();
		System.out.println(lt.levelOrderTraversal(root));

		lt.levelOrderTraversal_1(root);

	}
}
