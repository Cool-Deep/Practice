package com.interview.tree;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 03/22/2016
//// * @author Tushar Roy
//// *
//// * Given a binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes
//// * from some starting node to any node in the tree along the parent-child connections.
//// *
//// * Time complexity O(n)
//// * Space complexity depends on depth of tree.
//// *
//// * https://leetcode.com/problems/binary-tree-maximum-path-sum/
//// */
////class BinaryTreeMaximumPathSum {
////    private int max = 0;
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int maxPathSum(Node root) {
//////        max = Integer.MIN_VALUE;
//////        maxPathSumUtil(root);
//////        return max;
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private int maxPathSumUtil(Node root) {
////        if (root == null) {
////            return 0;
////        }
////        int left = maxPathSumUtil(root.left);
////        int right = maxPathSumUtil(root.right);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        if (left < 0) {
//            left = 0;
//        }
//        if (right < 0) {
//            right = 0;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        }
        max = Math.max(max, root.data + left + right);
        return root.data + Math.max(left, right);
    }
}
