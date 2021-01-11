package com.ds.tree;

import java.util.HashMap;
import java.util.Map;

/*

not a BST, this is Binary Tree
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class CovertBinaryTreeFromInOrderPreOrder {

    static Map<Integer, Integer> ioMap = new HashMap<>();

    private static TreeNode preOrderInOrderToBinaryTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) {
            ioMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int pos, int poe,
                     int[] inorder, int ios, int ioe) {

        // find the root index
        if(pos > poe) return null;

        // get the root value from preorder array at the start of index
        int rootValue = preorder[pos];

        // search for the value in the inorder array to get the root inorder array
        int rootIndex = ioMap.get(rootValue);


        int leftCount = rootIndex - ios;
        int rightCount = ioe - rootIndex;

        // create the root
        TreeNode root = new TreeNode(rootValue);


        // create the left and right subtrees
        root.left = helper(preorder, pos + 1, pos + leftCount,
                          inorder, ios, rootIndex - 1);

        root.right = helper(preorder, pos + leftCount + 1, poe,
                            inorder, rootIndex + 1, ioe);

        return root;

    }



    public static void main(String[] args) {

        int[] preorder = new int[] {3, 9, 20, 15, 7};
        int[] inorder = new int[] {9, 3, 15, 20, 7};
        preOrderInOrderToBinaryTree(preorder, inorder);
    }
}
