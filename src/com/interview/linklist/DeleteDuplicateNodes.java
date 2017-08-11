package com.interview.linklist;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 04/17/2016
//// * @author Tushar Roy
//// *
//// * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
//// * numbers from the original list.
//// *
//// * For example,
//// * Given 1->2->3->3->4->4->5, return 1->2->5.
//// * Given 1->1->1->2->3, return 2->3.
//// *
//// * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
//// */
////class DeleteDuplicateNodes {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public Node deleteDuplicates(Node head) {
//////        Node dummyNode = new Node();
//////        dummyNode.next = head;
//////        Node current = head;
//////        Node prev = dummyNode;
//////        while (current != null) {
//////            while(current.next != null && current.data == current.next.data) {
//////                current = current.next;
//////            }
//////            if (prev.next == current) {
//////                prev = current;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////            } else {
////                prev.next = current.next;
////            }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            current = current.next;
//        }
//        return dummyNode.next;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
