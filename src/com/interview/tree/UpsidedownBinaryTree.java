package com.interview.tree;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that
//// * shares the same parent node) or empty, flip it upside down and turn it into a tree where the original
//// * right nodes turned into left leaf nodes. Return the new root.
//// *
//// * https://leetcode.com/problems/binary-tree-upside-down/
//// */
////class UpsidedownBinaryTree {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public Node upsideDownBinaryTree(Node root) {
//////        if (root == null) {
//////            return null;
//////        }
//////        return upsideDownBinaryTree(root, null, null);
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private Node upsideDownBinaryTree(Node root, Node parent, Node rightChild) {
////        if (root == null) {
////            return parent;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        }
//        Node left = root.left;
//        Node right = root.right;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

        root.right = parent;
        root.left = rightChild;

        return upsideDownBinaryTree(left, root, right);
    }
}
