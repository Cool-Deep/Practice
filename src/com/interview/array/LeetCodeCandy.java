package com.interview.array;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * References
//// * https://leetcode.com/problems/candy/
//// */
////class LeetCodeCandy {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int candy(int[] ratings) {
//////        int pointOfChange = 0;
//////        int totalCandies = 1;
//////        int currentCandy = 1;
//////        boolean isIndependent = true;
//////        int maxHeight = 0;
//////        int diff = 0;
//////        for (int i = 1; i < ratings.length; i++) {
//////            diff = 0;
//////            if (ratings[i] > ratings[i-1]) {
//////                currentCandy += 1;
//////            } else if (ratings[i] == ratings[i-1]) {
//////                isIndependent = true;
//////                pointOfChange = i;
//////                currentCandy = 1;
//////            } else {
//////                if (currentCandy == 1) {
//////                    if (!isIndependent) {
//////                        if (i - pointOfChange == maxHeight - 1) {
//////                            pointOfChange--;
//////                        }
//////                    }
//////                }
//////                else {
//////                    maxHeight = currentCandy;
//////                    currentCandy = 1;
//////                    isIndependent = false;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                    pointOfChange = i;
////                }
////                diff = i - pointOfChange;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            }
//            totalCandies += (diff + currentCandy);
//        }
//        return totalCandies;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
