package com.interview.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/find-number-pairs-xy-yx/
 */
class NumberOfPairWithXPowerYGreaterThanYPowerX {

    private int countPairs(int X[], int Y[]){
        Map<Integer,Integer> hardCoded = new HashMap<>();
        for (int aY : Y) {
            if (aY < 4) {
                Integer count = hardCoded.get(aY);
                if (count != null) {
                    hardCoded.put(aY, count++);
                } else {
                    hardCoded.put(aY, 1);
                }
            }
        }
        Arrays.sort(Y);
        int countPairs = 0;
        for (int aX : X) {
            countPairs += count(aX, Y, hardCoded);
        }
        return countPairs;
    }
    
    private int count(int x, int Y[],Map<Integer,Integer> hardCount){
        
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return upperBound(0,Y);
        }
        int result = Y.length - upperBound(x,Y);
        result +=  (hardCount.getOrDefault(1, 0)) + (hardCount.getOrDefault(0, 0));
    
        if(x == 2){
            result -= (hardCount.getOrDefault(3, 0));
        }
        if(x == 3){
            result += (hardCount.getOrDefault(2, 0));
        }
        return result;
    }
    
    private int upperBound(int x, int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] > x && (mid-1 < 0 || arr[mid-1] <= x)){
                return mid;
            }else if(arr[mid] > x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
        
    }
    
    public static void main(String args[]){
        NumberOfPairWithXPowerYGreaterThanYPowerX nop = new NumberOfPairWithXPowerYGreaterThanYPowerX();
        int X[] = {7,9,5,8,9,11,0,1,1,3};
        int Y[] = {6,8,9,11,14,5,1,0,2,3,9};
        System.out.println(nop.countPairs(X, Y));
    }
}
