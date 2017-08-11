package com.interview.tree;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given inorder and postorder traversal of a tree, construct the binary tree.
//// *
//// * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//// */
////class ContructTreeFromInorderPostOrder {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public Node buildTree(int[] inorder, int[] postorder) {
//////        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private Node buildTree(int[] inorder, int[] postorder, int start, int end, int index) {
////        if (start > end) {
////            return null;
////        }
////
////        int i;
////        for (i = start; i <= end; i++) {
////            if (postorder[index] == inorder[i]) {
////                break;
////            }
////        }
////
////        Node tn = Node.newNode(postorder[index]);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        tn.left = buildTree(inorder, postorder, start, i - 1, index - (end - i + 1));
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        tn.right = buildTree(inorder, postorder, i + 1, end, index - 1);
        return tn;
    }
}
