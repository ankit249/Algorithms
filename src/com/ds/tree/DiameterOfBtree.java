package com.ds.tree;

/*

Diameter is bottom up approach  (bottomUpDFS)

       1
     /   \
    2    3
  /  \
 4    5
length is the distance from 1 node to another
diameter - doesn't have to go thru root

its like post order traversal (left, right and then root)


length from 4 yo 5 is 2: 4>2 and 2>5
possible diameters here are 4-2-5, 4-2-1-3, 5-2-1-3

max diameters are [4,2,1,5], [5,2,1,3]

The reason this is bottom up approach is you can't make a decision until you know the leaf node,
this is why you are using post order traversal here --> left, right, root

TC: O(N)
SC: O(N)


*/
public class DiameterOfBtree {

    private static int maxDiameter = 0;

    public static int getDiameterOfTree(TreeNode root) {

        if(root == null) return maxDiameter;

        // recurse
        helper(root);
        return maxDiameter;

    }

    private static int helper(TreeNode node) {

        // base case: if leaf return 0
        if(node.left == null && node.right == null) {
            return 0;
        }

        //recursion
        int ldist = 0; int rdist = 0;

        // ldist = (distance of left child) + 1
        if(node.left != null) {
            ldist = helper(node.left) + 1;
        }

        // rdist = (distance of right child) + 1
        if(node.right != null) {
            rdist = helper(node.right) + 1;
        }

        // check if mydisance > maxDistance
        int mydistance = ldist + rdist;
        maxDiameter = Math.max(maxDiameter, mydistance);

        // return whichever is larger: ldist or rdist
        return Math.max(ldist, rdist);
    }


    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(30);
        bst.insert(root, 20);
        bst.insert(root, 25);
        bst.insert(root, 15);
        bst.insert(root, 17);
        bst.insert(root, 50);
        bst.insert(root, 40);
        bst.insert(root, 60);
        BTreePrinter.printNode(root);
        System.out.println(getDiameterOfTree(root));

        root = new TreeNode(30);
        bst.insert(root, 50);
        bst.insert(root, 40);
        bst.insert(root, 60);
        bst.insert(root, 40);
        bst.insert(root, 39);
        bst.insert(root, 38);
        bst.insert(root, 37);
        bst.insert(root, 36);
        bst.insert(root, 35);

        //BTreePrinter.printNode(root);
        System.out.println(getDiameterOfTree(root));
    }

}
