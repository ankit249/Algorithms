package com.ds.tree;
/*
Upside Down


?/NOT COMPLETE
Given a binary tree where every node has either 0 or 2 children and every right node is a leaf node, flip it upside down turning it into a binary tree where all left nodes are leafs.

https://uplevel.interviewkickstart.com/resource/rc-codingproblem-11858-97908-51-322
 */
public class UpsideDownTree {
    private static TreeNode flipUpsideDown(TreeNode root){
        return helper(root);
    }


    private static TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode current = helper(root.left);
        if(current == null) {
            return root;
        }

        TreeNode parent = current;
        parent.left = current.right;
        parent.right = current;
        return parent;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(root, 20);
        bst.insert(root, 15);
        bst.insert(root, 25);
        bst.insert(root, 50);


        BTreePrinter.printNode(root);

        TreeNode result = flipUpsideDown(root);
        BTreePrinter.printNode(result);

    }
}
