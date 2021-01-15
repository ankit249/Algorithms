package com.ds.tree;

import java.util.Vector;

/*
Height Of K Ary Tree
Height Of K Ary Tree



Given a k-ary tree, find the height of that tree: number of edges in the longest path from the root to any node.

A k-ary tree is a rooted tree in which each node has no more than k children.



Example

Input is a 3-ary tree:

  1
/ | \
2 3 5
    |
    4

Output: 2

The longest path from the root is 1 -> 5 -> 4. It has two edges.

*/

//TC - O(n)
//SC - O(h) or (Ologn) if its balanced tree - maximum space is height of the tree (stack space)
class HeightOfKArrayTree {

    static class TreeNode
    {
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode()
        {
            children.clear();
        }
    };
    static int max_distance = 0;
    static int find_height(TreeNode root)
    {
        if(root == null) return 0;
        helper(root, 0);
        return max_distance;
    }
    static void helper(TreeNode n, int distance) {

        // if no children
        if(n != null && n.children.size() == 0) {
            max_distance = Math.max(max_distance, distance);
            return;
        }

        for(TreeNode node : n.children) {
            helper(node, distance + 1);
        }
    }


}

