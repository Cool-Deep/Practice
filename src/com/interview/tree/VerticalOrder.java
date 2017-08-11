package com.interview.tree;

import java.util.*;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//// * If two nodes are in the same row and column, the order should be from left to right.
//// *
//// * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
//// */
////class VerticalOrder {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public List<List<Integer>> verticalOrder(Node root) {
//////        if (root == null) {
//////            return new ArrayList<>();
//////        }
//////        int minVal = 0;
//////        int maxVal = 0;
//////        Map<Integer, List<Integer>> map = new HashMap<>();
//////
//////        Deque<Node> queue = new LinkedList<>();
//////        Deque<Integer> verticalQueue = new LinkedList<>();
//////
//////        queue.offerFirst(root);
//////        verticalQueue.offerFirst(0);
//////        int vertical;
//////        while (!queue.isEmpty()) {
//////            root = queue.pollFirst();
//////            vertical = verticalQueue.pollFirst();
//////            minVal = Math.min(minVal, vertical);
//////            maxVal = Math.max(maxVal, vertical);
//////
//////            List<Integer> r = map.get(vertical);
//////            if (r == null) {
//////                r = new ArrayList<>();
//////                map.put(vertical, r);
//////            }
//////            r.add(root.data);
//////
//////            if (root.left != null) {
//////                queue.offerLast(root.left);
//////                verticalQueue.offerLast(vertical - 1);
//////            }
//////
//////            if (root.right != null) {
//////                queue.offerLast(root.right);
//////                verticalQueue.offerLast(vertical + 1);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////            }
////        }
////
////        List<List<Integer>> result = new ArrayList<>();
////        for (int i = minVal; i <= maxVal; i++) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            List<Integer> r = map.get(i);
//            result.add(r);
//        }
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}