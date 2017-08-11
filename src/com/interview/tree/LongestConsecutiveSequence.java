package com.interview.tree;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Created by tushar_v_roy on 4/1/16.
//// */
////class LongestConsecutiveSequence {
////    private int max = 0;
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int longestConsecutive(Node root) {
//////        if (root == null) {
//////            return 0;
//////        }
//////        max = 0;
//////        longestConsecutiveUtil(root, root.data - 1, 0);
//////        return max;
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private void longestConsecutiveUtil(Node root, int prevData, int current) {
////        if (root == null) {
////            return;
////        }
////
////        if (root.data == prevData + 1) {
////            current = current + 1;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        } else {
//            current = 1;
//        }
//        max = Math.max(current, max);
//        longestConsecutiveUtil(root.left, root.data, current);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        longestConsecutiveUtil(root.right, root.data, current);
    }
}
