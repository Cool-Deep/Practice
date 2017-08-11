package com.interview.linklist;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//// * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//// *
//// * https://leetcode.com/problems/reorder-list/
//// */
////class ReorderList {
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public void reorderList(Node head) {
//////        Node back = frontBackSplit(head);
//////        back = reverse(back);
//////        alternateMerge(head, back);
//////
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private void alternateMerge(Node head1, Node head2) {
////        Node dummyHead = new Node();
////        Node current = dummyHead;
////        while (head1 != null && head2 != null) {
////            current.next= head1;
////            head1 = head1.next;
////            current = current.next;
////            current.next = head2;
////            head2 = head2.next;
////            current = current.next;
////        }
////        current.next = head1;
////    }
////
////    private Node reverse(Node head) {
////        if (head == null) {
////            return null;
////        }
////        Node front = null;
////        Node mid = head;
////        Node next = null;
////        while (mid != null) {
////            next = mid.next;
////            mid.next = front;
////            front = mid;
////            mid = next;
////        }
////        return front;
////    }
////
////    private Node frontBackSplit(Node head) {
////        if (head == null) {
////            return null;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        }
//        Node slow = head;
//        head = head.next;
//        while (head != null && head.next != null) {
//            slow = slow.next;
//            head = head.next.next;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        }
        Node next = slow.next;
        slow.next = null;
        return next;
    }
}
