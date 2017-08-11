package com.interview.multiarray;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
///**
// *
// * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
// * (row1, col1) and lower right corner (row2, col2).
// *
// * https://leetcode.com/problems/range-sum-query-2d-mutable/
// */
//class Mutable2DSumRangeQuery {
//    private int[][] prefixSum;
//    private int cols;
//    private int[][] matrix;
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public Mutable2DSumRangeQuery(int[][] matrix) {
////        if (matrix.length == 0) {
////            return;
////        }
////        prefixSum = new int[matrix.length][matrix[0].length + 1];
////        this.matrix = matrix;
////        int rows = matrix.length;
////        cols = matrix[0].length;
////        for (int i = 0; i < rows; i++) {
////            for (int j = 1; j <= cols; j++) {
////                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
////            }
////        }
////
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public void update(int row, int col, int val) {
////        int delta = val - matrix[row][col];
////        matrix[row][col] = val;
////        for (int i = col + 1; i <= cols; i++) {
////            prefixSum[row][i] += delta;
////        }
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            sum += prefixSum[i][col2 + 1] - prefixSum[i][col1];
//        }
//        return sum;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}