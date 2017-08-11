package com.interview.array;

import java.util.Arrays;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Given an array of n integers nums and a target, find the number of index triplets i, j, k
//// * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//// *
//// * https://leetcode.com/problems/3sum-smaller/
//// */
////class ThreeSumSmallerThanTarget {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int threeSumSmaller(int[] nums, int target) {
//////        if (nums.length < 3) {
//////            return 0;
//////        }
//////        Arrays.sort(nums);
//////        int count = 0;
//////        for (int i = 0; i < nums.length; i++) {
//////            int j = i + 1;
//////            int k = nums.length - 1;
//////            while (j < k) {
//////                if (nums[i] + nums[j] + nums[k] >= target) {
//////                    k--;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                } else {
////                    count += k - j;
////                    j++;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//                }
//            }
//        }
//        return count;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
