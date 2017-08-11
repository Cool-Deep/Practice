package com.interview.binarysearch;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Created by tushar_v_roy on 3/21/16.
//// */
////class MinimumInSortedRotatedArray {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int findMin(int[] nums) {
//////        int low = 0;
//////        int high = nums.length - 1;
//////        while (low < high) {
//////            int middle = (low + high)/2;
//////            if ((middle == 0 || nums[middle] < nums[middle - 1]) && (middle == nums.length - 1 || nums[middle] < nums[middle + 1])) {
//////                return nums[middle];
//////            }
//////            else if (nums[middle] > nums[high]) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                low = middle + 1;
////            } else {
////                high = middle - 1;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            }
//        }
//
//        return nums[low];
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
