package com.ds.tree;

import java.util.concurrent.TimeUnit;

/*
        5
     /    \    <-- this is not univalue subtree
    1      5
  /  \      \  <-- this is univalue subtree
 5   5      5
-    -     -    <-- All the leafs are univalue and added to the count

 Uinvalue subtree (All leafs are univalue subtree)
 5 --> 5 is a universal subtree -- so there are total 4 outputs

    5   <-- this is not a univalue since 5 has 1 and 5 child.
   / \
  1  5
  -  -
 underlined leafs are univaluse , so univalue count is 2.


This is also (bottomUpDFS) approach

 */
public class UnivalueSubTree {

    private static int uValueCount = 0;

    public static int getUnivalueOfTree(TreeNode root) {

        if(root == null) return uValueCount;

        // recurse
        helper(root);
        return uValueCount;

    }

    private static boolean helper(TreeNode node) {
        // base case: if leaf return 1
        if(node.left == null && node.right == null) {
            // add 1 to univalue count;
            uValueCount++;
            return true;
        }

        //recursion
        // if i don't have a left child lUval should be initialized to true
        boolean lUval = true; boolean rUval = true; boolean myUval = true;


        // check if left is unival
        if(node.left != null) {
            lUval = helper(node.left);
            myUval = (node.data == node.left.data) && lUval;
        }

        // check if right is unival
        if(node.right != null) {
            rUval = helper(node.right);
            myUval = (myUval) && (node.data == node.right.data) && rUval;
        }

        // check if imunival = (node.data == node.left.data && node.data == node.right.data)
        //  myUval = node.data == node.left.data && node.data == node.right.data; <-- THIS GIVES NULL POINTER EXCEPTION

        // if lUval, rUVal and myUVal == add 1
        if(myUval) {
            uValueCount ++;
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(30);
        bst.insert(root, 20);
        bst.insert(root, 25);
        bst.insert(root, 15);
        bst.insert(root, 15);
        bst.insert(root, 50);
        bst.insert(root, 40);
        bst.insert(root, 60);

        BTreePrinter.printNode(root);

        System.out.println(getUnivalueOfTree(root));
    }
}
