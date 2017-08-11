package com.interview.array;

/**
 * Date 03/12/2016
 * @author Tushar Roy
 *
 * Given an unsorted array find maximum gap between consecutive element in sorted array.
 *
 * Time complexity O(n)
 * Space complexity O(n)
 *
 * Reference
 * https://leetcode.com/problems/maximum-gap/
 */
class MaximumGap {

    class Bucket {
        int low ;
        int high;
        boolean isSet = false;
        void update(int val) {
            if (!isSet) {
                low = val;
                high = val;
                isSet = true;
            } else {
                low = Math.min(low, val);
                high = Math.max(high, val);
            }
        }
    }

    private int maximumGap(int[] input) {
        if (input == null || input.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int anInput1 : input) {
            min = Math.min(min, anInput1);
            max = Math.max(max, anInput1);
        }

        int gap = (int) Math.ceil((double) (max - min) / (input.length - 1));

        Bucket[] buckets = new Bucket[input.length - 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int anInput : input) {
            if (anInput == max || anInput == min) {
                continue;
            }
            buckets[(anInput - min) / gap].update(anInput);
        }

        int prev = min;
        int maxGap = 0;
        for (Bucket bucket : buckets) {
            if (!bucket.isSet) {
                continue;
            }
            maxGap = Math.max(maxGap, bucket.low - prev);
            prev = bucket.high;
        }

        return Math.max(maxGap, max - prev);
    }

    public static void main(String args[]) {
        int[] input = {4, 3, 13, 2, 9, 7};
        MaximumGap mg = new MaximumGap();
        System.out.println(mg.maximumGap(input));
    }
}
