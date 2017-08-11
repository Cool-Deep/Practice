package com.interview.binarysearch;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * https://leetcode.com/problems/search-insert-position/
//// */
////class SearchInsertPosition {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int searchInsert(int[] nums, int target) {
//////        int low = 0;
//////        int high = nums.length - 1;
//////        while (low <= high) {
//////            int middle = (low + high)/2;
//////            if (nums[middle] == target) {
//////                return middle;
//////            }
//////            if (nums[middle] < target && (middle == nums.length - 1 ||  nums[middle + 1] > target)) {
//////                return middle + 1;
//////            }
//////            if (nums[middle] < target) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                low = middle + 1;
////            } else {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//                high = middle - 1;
//            }
//        }
//        return 0;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
