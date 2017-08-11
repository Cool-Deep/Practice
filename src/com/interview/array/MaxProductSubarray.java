package com.interview.array;

/**
 * Date 04/`7/2016
 * @author Tushar Roy
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Time complexity is O(n)
 * Space complexity is O(1)
 *
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 * https://leetcode.com/problems/maximum-product-subarray/
 */
class MaxProductSubarray {

    private int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int maxSoFar = nums[0];
        for (int num : nums) {
            if (num > 0) {
                max = max * num;
                min = Math.min(min * num, 1);
                maxSoFar = Math.max(maxSoFar, max);
            } else if (num == 0) {
                min = 1;
                max = 1;
                maxSoFar = Math.max(maxSoFar, 0);
            } else {
                int t = max * num;
                maxSoFar = Math.max(maxSoFar, min * num);
                max = Math.max(1, min * num);
                min = t;
            }
        }
        return maxSoFar;
    }
    
    public static void main(String args[]){
        MaxProductSubarray mps = new MaxProductSubarray();
        int input[] = {-6, -3, 8, -9, -1, -1, 3, 6, 9, 0, 3, -1};
        System.out.println(mps.maxProduct(input));
    }
}
