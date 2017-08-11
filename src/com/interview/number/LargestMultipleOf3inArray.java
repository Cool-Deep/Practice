package com.interview.number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/
 */
class LargestMultipleOf3inArray {

    private void swap(int input[], int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    private void reverse(int input[]){
        for(int i=0; i < input.length/2; i++){
            swap(input,i, input.length-1-i);
        }
    }
    
    private int[] largestMultiple(int input[]){
        Arrays.sort(input);
        int output[];
        Queue<Integer> q0 = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        int sum = 0;
        for (int anInput : input) {
            if (anInput % 3 == 0) {
                q0.add(anInput);
            }
            if (anInput % 3 == 1) {
                q1.add(anInput);
            }
            if (anInput % 3 == 2) {
                q2.add(anInput);
            }
            sum += anInput;
        }
    
        if(sum % 3 == 0){
            output = new int[input.length];
            for(int i=0; i < input.length; i++){
                output[input.length-1-i] = input[i];
            }
            return output;
        }
        else if(sum % 3 == 1){
            int len = input.length;
            if(q1.size() > 0){
                q1.poll();
                len--;
            }else if (q2.size() > 1){
                q2.poll();
                q2.poll();
                len -= 2;
            }else{
                return null;
            }
            output = new int[len];
            int i=0;
            while(q0.size() > 0){
                output[i] = q0.poll();
                i++;
            }
            while(q1.size() > 0){
                output[i] = q1.poll();
                i++;
            }
            while(q2.size() > 0){
                output[i] = q2.poll();
                i++;
            }
            Arrays.sort(output);
            reverse(output);
        }else{
            int len = input.length;
            if(q2.size() > 0){
                q2.poll();
                len--;
            }else if(q1.size() > 1){
                q1.poll();
                q1.poll();
                len -= 2;
            }else{
                return null;
            }
            output = new int[len];
            int i=0;
            while(q0.size() > 0){
                output[i] = q0.poll();
                i++;
            }
            while(q1.size() > 0){
                output[i] = q1.poll();
                i++;
            }
            while(q2.size() > 0){
                output[i] = q2.poll();
                i++;
            }
            Arrays.sort(output);
            reverse(output);
        }
        return output;
    }
    
    public static void main(String args[]){
        int input[] = {8,9,0,2,2,2};
        LargestMultipleOf3inArray lma = new LargestMultipleOf3inArray();
        int output[] = lma.largestMultiple(input);
        for(int a : output){
            System.out.print(a + " ");
        }
    }
}

