package com.ds.tree;
import javax.management.Query;
import java.util.*;

//TODO

public class BinaryTreeOrderTraversalBottomToTop {
    public static void levelOrderTraversalBottomToTop(TreeNode root) {

        Stack<List<Integer>> finalList = new Stack<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();

        currentQueue.offer(root);
        while (!currentQueue.isEmpty()) {
            TreeNode tmp = currentQueue.poll();
            list.add(tmp.data);

            if(tmp.left != null) {
                nextQueue.offer(tmp.left);
            }

            if(tmp.right != null) {
                nextQueue.offer(tmp.right);
            }

            if(currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                finalList.push(list);
                list = new ArrayList<>();
                nextQueue = new LinkedList<>();
            }

        }

        while(!finalList.isEmpty()) {
            System.out.println(finalList.pop());
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


        levelOrderTraversalBottomToTop(root);

    }
}
