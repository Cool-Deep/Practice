package com.interview.dynamic;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * https://leetcode.com/problems/perfect-squares/
//// */
////class MinimumNumberOfPerfectSquares {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int numSquares(int n) {
//////        int count = (int)Math.ceil(Math.sqrt(n));
//////
//////        int[] T = new int[n + 1];
//////
//////        T[0] = 0;
//////
//////        for (int i = 1; i < T.length; i++) {
//////            T[i] = Integer.MAX_VALUE;
//////            for (int j = 1; j <= count; j++) {
//////                if (i < j*j) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                    break;
////                }
////                T[i] = Math.min(T[i], T[i - j*j] + 1);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            }
//        }
//        return T[n];
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
