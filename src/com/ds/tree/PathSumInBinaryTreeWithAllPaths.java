package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

/*
TC - O(NlogN)

if my binary tree is like this:

       2
    /    \
   2     2
  / \   / \
 2  2  2  2

result would be if the target == 6
[
	[2,2,2],
	[2,2,2],
	[2,2,2],
	[2,2,2]
]

logN * (N + 1) / 2

SC - O(NlogN)

 */

/*
   7
  / \
 /   \
 5   9
/ \ / \
4 6 8 23

for target 24 : [[7, 9, 8]]
 */
public class PathSumInBinaryTreeWithAllPaths {


	private static List<List<Integer>> listPathSum(TreeNode node, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> slate = new ArrayList<>();

		if(node == null) {
			return result;
		}

		helper(node, slate, target, result);
		return result;
	}


	// you can use slate as a stack and use push and pop
	private static void helper(TreeNode node, List<Integer> slate, int target, List<List<Integer>> result) {

		slate.add(node.data);
		target = target - node.data;

		// base condition
		if(node.left == null && node.right == null) {
			if(target == 0)  {
				// you need a new copy of slate becuase at that point what was the slate
				result.add(new ArrayList<>(slate));
			}
			slate.remove(slate.size() - 1); // this condition is needed if the sum is in the right subtree (e.g. 24 instead of 16)
			return;
		}


		if(node.left != null) {
			helper(node.left, slate, target, result);
		}

		if(node.right != null) {
			helper(node.right, slate, target, result);
		}
		slate.remove(slate.size() - 1);
	}


	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		/*
		TreeNode root = new TreeNode(3);
		bst.insert(root, 1);
		bst.insert(root, -1);
		bst.insert(root, -2);
		bst.insert(root, 2);
		bst.insert(root, 4);

		 */

		TreeNode root = new TreeNode(7);
		bst.insert(root, 5);
		bst.insert(root, 9);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 8);
		bst.insert(root, 23);
		//bst.insert(root, 17);
		//bst.insert(root, 20);
		//bst.insert(root, 22);
		//bst.insert(root, 24);
		//bst.insert(root, 16);
		//bst.insert(root, 18);
		BTreePrinter.printNode(root);


		System.out.println("For Target Value = 16: " + listPathSum(root, 16));
		System.out.println("For Target Value = 24: " + listPathSum(root, 24));

		System.out.print(
				"The Sum (might not go thru root just like this example, diameter is no. of nodes in this path): ");
	}
}
