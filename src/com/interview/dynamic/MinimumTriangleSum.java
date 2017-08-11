package com.interview.dynamic;

import java.util.List;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on
//// * the row below.
//// * https://leetcode.com/problems/triangle/
//// */
////class MinimumTriangleSum {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int minimumTotal(List<List<Integer>> triangle) {
//////        int n = triangle.size();
//////        int[] dp = new int[n];
//////
//////        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
//////            dp[i] = triangle.get(n - 1).get(i);
//////        }
//////
//////        for (int i = triangle.size() - 2; i >= 0; i--) {
//////            for (int j = 0; j < triangle.get(i).size(); j++) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            }
//        }
//        return dp[0];
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
