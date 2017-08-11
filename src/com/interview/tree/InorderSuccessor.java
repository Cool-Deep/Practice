package com.interview.tree;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 03/27/2016
//// * @author Tushar Roy
//// *
//// * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//// *
//// * Time complexity O(h)
//// * Space complexity O(h)
//// *
//// * https://leetcode.com/problems/inorder-successor-in-bst/
//// */
////class InorderSuccessor {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public Node inorderSuccessor(Node root, Node p) {
//////        if (p.right != null) {
//////            p = p.right;
//////            while (p.left != null) {
//////                p = p.left;
//////            }
//////            return p;
//////        } else {
//////            return succ(root, p.data);
//////        }
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private Node succ(Node root, int data) {
////        if (root.data == data) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            return null;
//        }
//        if (root.data < data) {
//            return succ(root.right, data);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        } else {
            Node s = succ(root.left, data);
            return s == null ? root : s;
        }
    }
}
