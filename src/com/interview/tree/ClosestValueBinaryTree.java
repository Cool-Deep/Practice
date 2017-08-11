package com.interview.tree;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//// * https://leetcode.com/problems/closest-binary-search-tree-value/
//// */
////class ClosestValueBinaryTree {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int closestValue(Node root, double target) {
//////        int r = target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//////        return closestValueUtil(root, target, r);
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private int closestValueUtil(Node root, double target, int result) {
////        if (root == null) {
////            return (int)result;
////        }
////        if (target == root.data) {
////            return root.data;
////        }
////        if (Math.abs(root.data - target) < Math.abs(result - target)) {
////            result = root.data;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        }
//        if (target < root.data) {
//            return closestValueUtil(root.left, target, result);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        } else {
            return closestValueUtil(root.right, target, result);
        }
    }
}
