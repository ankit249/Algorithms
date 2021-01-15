package com.ds.tree;

import com.sun.source.tree.Tree;

/*
Kth Smallest Element Of BST
Given a binary search tree (BST) and an integer k, find k-th smallest element.
Example

Input:
BST:

       30
     /   \
   20    50
  / \   / \
15 25  40 60

k: 3
Output: 25

The 3rd smallest element is 3.

TC: if the tree is not balanced you can go all the way left to find the smallest first so thats O(n) plus k more which O(k)
    O(n + K) => O(n)

SC: no extra space, however we are using stack space in recursion - k times
    Avg. case O(h + k) > O(logn + k)

 */
public class KthSmallestinBST {

    static int count = 1;
    public static int kthSmallest(TreeNode root, int k) {
        TreeNode tmp = helper(root, k);
        if(tmp == null) {
            return -1;
        } else {
            return tmp.data;
        }
    }

    private static TreeNode helper(TreeNode root, int k) {
        if(root == null) return null;

        TreeNode left =  helper(root.left, k);
        if(left != null) {
            return left;
        }

        if(count == k) {
            return root;
        }
        count++;

        return helper(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(root, 20);
        bst.insert(root, 15);
        bst.insert(root, 25);
        bst.insert(root, 50);
        bst.insert(root, 40);
        bst.insert(root, 60);

        BTreePrinter.printNode(root);

        System.out.println(kthSmallest(root, 5));

    }
}
