package com.ds.tree;

/*
TC - O(N) because you are going thru all N elements
SC - O(N) -- stack space is being used within recursion, and space is propotional to the height of the tree, for lobsided tree
		     it will be O(N)
 */
public class PathSumInBinaryTree {

	private static boolean flag;
	private static boolean hasPathSum(TreeNode node, int target) {
		flag = false;
		helper(node, target);
		return flag;
	}

	// flag is global variable
	// if you want to use pass it by reference (encapsulate it) pass it as a boolean[] and not boolean <-
	// boolean[] will pass by reference and boolean premitive will be lost so in this case flag will be replaced by flag[0]
	private static void helper(TreeNode node, int target) {

		// pruning condition - optimization
		if(flag) {
			return;
		}

		target = target - node.data;

		// base condition
		if(node.left == null && node.right == null) {
			if(target == 0)  {
				flag = true;
			}
			return;
		}

		if(node.left != null) {
			helper(node.left, target);
		}

		if(node.right != null) {
			helper(node.right, target);
		}
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
		bst.insert(root, 21);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 19);
		bst.insert(root, 23);
		//bst.insert(root, 17);
		//bst.insert(root, 20);
		//bst.insert(root, 22);
		//bst.insert(root, 24);
		//bst.insert(root, 16);
		//bst.insert(root, 18);
		BTreePrinter.printNode(root);

		System.out.println(hasPathSum(root, 16));

		System.out.print(
				"The Sum (might not go thru root just like this example, diameter is no. of nodes in this path): ");
	}
}
