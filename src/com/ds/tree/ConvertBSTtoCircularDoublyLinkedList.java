package com.ds.tree;


/*
USING IN PLACE , modify the incoming BST to doubly linked list

Traversing in order traversal -

                4
              /   \
            2      5
          /  \
         1    3


result to be (Doubly link list)

  1 ->  2 ->  3  -> 4  -> 5
  1 <-  2 <-  3  <- 4  <- 5

explanation

-- traverse inorder until you get to 1
-- sentinel node 0
-- sendile node 0.right = 1 and 1.left = 0

-- now predeceor = 1
--

-- predecisor = 5 at the end


 */


public class ConvertBSTtoCircularDoublyLinkedList {

    TreeNode sentinel = new TreeNode(0);

    public TreeNode bstToDLL(TreeNode root) {
        // create a sentinel and a predecessor
        TreeNode pred = sentinel;

        // wire up items
        wireUpDLL(root, pred);

        // connect the last predecessor to the first node
        // 5 node.right      1 node
        pred.right = sentinel.right;

        // 1 node  left      5 node
        sentinel.right.left = pred;

        // return the first node
        return sentinel.right;

    }

    private void wireUpDLL(TreeNode node, TreeNode pred) {

        // traverse left
        if(node.left != null) wireUpDLL(node, pred);

        // connect predecessor to current node
        pred.right = node;
        node.left = pred;
        pred = node;

        // traverse right
        if(node.right != null) wireUpDLL(node, pred);

    }

}
