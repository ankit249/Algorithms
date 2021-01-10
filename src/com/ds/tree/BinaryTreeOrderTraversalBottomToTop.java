package com.ds.tree;
import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO

public class BinaryTreeOrderTraversalBottomToTop {
    public List<Integer> levelOrderTraversalBottomToTop(TreeNode root) {

        List<Integer> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> previousQueue = new LinkedList<>();

        currentQueue.offer(root);
        while (!currentQueue.isEmpty()) {
            TreeNode tmp = currentQueue.poll();
            list.add(tmp.data);

            if(tmp.left != null) {
                
            }

        }

        return finalList;
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

        BinaryTreeOrderTraversalBottomToTop lt = new BinaryTreeOrderTraversalBottomToTop();
        System.out.println(lt.levelOrderTraversalBottomToTop(root));

    }
}
