package com.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeTwoBST {

    public static TreeNode mergeTwoBSTs(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = inorderTraveral(root1);
        List<Integer> l2 = inorderTraveral(root2);
        List<Integer> result = merge(l1, l2);
        System.out.println(result);
        return sortedArrayToBST(result, 0, result.size() - 1);
    }

    private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < l1.size() && j < l2.size()) {
            if(l1.get(i) <= l2.get(j)) {
                result.add(l1.get(i));
                i++;
            } else {
                result.add(l2.get(j));
                j++;
            }
        }
        while(i < l1.size()) {
            result.add(l1.get(i));
            i++;
        }
        while(j < l2.size()) {
            result.add(l2.get(j));
            j++;
        }
        return result;
    }

    private static List<Integer> inorderTraveral(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode n = stack.pop();
                result.add(n.data);
                current = n.right;
            }
        }
        return result;
    }

    private static TreeNode sortedArrayToBST(List<Integer> a, int lo, int hi) {

        if (lo > hi)
            return null;

        int mid = lo + (hi - lo) / 2;   // avoid the overflow
        // find root
        TreeNode root = new TreeNode(a.get(mid));
        root.left = sortedArrayToBST(a, lo, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, hi);

        return root;
    }
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode t1 = new TreeNode(30);
        bst.insert(t1, 20);
        bst.insert(t1, 25);
        bst.insert(t1, 50);
        bst.insert(t1, 40);
        bst.insert(t1, 60);
        bst.insert(t1, 15);
        BTreePrinter.printNode(t1);

        TreeNode t2 = new TreeNode(29);
        bst.insert(t2, 19);
        bst.insert(t2, 25);
        bst.insert(t2, 49);
        bst.insert(t2, 39);
        bst.insert(t2, 59);
        bst.insert(t2, 15);
        BTreePrinter.printNode(t2);

        TreeNode result = mergeTwoBSTs(t1, t2);
        BTreePrinter.printNode(result);
    }
}
