package com.interview.bits;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 04/03/2016
//// * @author Tushar Roy
//// *
//// * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
//// * the number of 1's in their binary representation and return them as an array.
//// *
//// * Time complexity O(n)
//// * Space complexity O(n)
//// *
//// * https://leetcode.com/problems/counting-bits/
//// */
////class CountingBitsTillNum {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int[] countBits(int num) {
//////        if (num == 0) {
//////            return new int[1];
//////        }
//////        int[] count = new int[num + 1];
//////        count[0] = 0;
//////        int n = 1;
//////        int start = n;
//////        while (start <= num) {
//////            start = n;
//////            count[start++] = 1;
//////            int end = n<<1;
//////            while (start < end && start <= num) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                count[start] = 1 + count[start - n];
////                start++;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            }
//            n = n<<1;
//        }
//        return count;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
