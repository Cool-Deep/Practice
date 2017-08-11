package com.interview.array;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * https://leetcode.com/problems/first-missing-positive/
//// */
////class FirstPositiveMissing {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int firstMissingPositive(int[] nums) {
//////        int startOfPositive = segregate(nums);
//////        for (int i = startOfPositive; i < nums.length; i++) {
//////            int index = Math.abs(nums[i]) + startOfPositive - 1;
//////            if (index < nums.length) {
//////                nums[index] = -Math.abs(nums[index]);
//////            }
//////        }
//////        for (int i = startOfPositive; i < nums.length; i++) {
//////            if (nums[i] > 0) {
//////                return i - startOfPositive + 1;
//////            }
//////        }
//////        return nums.length - startOfPositive + 1;
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private int segregate(int[] nums) {
////        int start = 0;
////        int end = nums.length -1 ;
////        while (start <= end) {
////            if (nums[start] <= 0) {
////                start++;
////            } else if (nums[end] > 0) {
////                end--;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            } else {
//                swap(nums, start, end);
//            }
//        }
//        return start;
//    }
//
//    private void swap(int[] nums, int start, int end) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        int t = nums[start];
        nums[start] = nums[end];
        nums[end] = t;
    }
}
