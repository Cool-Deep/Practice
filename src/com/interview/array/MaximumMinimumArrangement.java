package com.interview.array;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 04/16/2016
//// * @author Tushar Roy
//// *
//// * Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value,
//// * second minimum value, third second max, fourth second min and so on.
//// *
//// * Time complexity O(n)
//// * Space complexity O(1)
//// *
//// * http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
//// */
////class MaximumMinimumArrangement {
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public void rearrange(int[] input) {
//////        for (int i = 0; i < input.length; i++) {
//////            int t = input[i];
//////            if (t < 0) {
//////                continue;
//////            }
//////            int i1 = i;
//////            while (true) {
//////                int j = i1 < input.length/2 ? 2 * i1 + 1 : (input.length - 1 - i1) * 2;
//////                if (j == i1) {
//////                    break;
//////                }
//////                if (input[j] < 0) {
//////                    break;
//////                }
//////                int t1 = input[j];
//////                input[j] = -t;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                t = t1;
////                i1 = j;
////            }
////        }
////
////        for (int i = 0; i < input.length; i++) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            input[i] = Math.abs(input[i]);
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
