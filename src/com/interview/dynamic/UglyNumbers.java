package com.interview.dynamic;

import java.util.PriorityQueue;

/**
 * Date 03/08/2016
 * @author Tushar Roy
 *
 * Find nth ugly number.
 *
 * https://leetcode.com/problems/ugly-number-ii/
 * https://leetcode.com/problems/super-ugly-number/
 * http://www.geeksforgeeks.org/ugly-numbers/
 */
class UglyNumbers {

    static class Node implements Comparable<Node> {
        final int inputIndex;
        int index;
        int val;
        Node(int inputIndex, int val) {
            this.index = 0;
            this.val = val;
            this.inputIndex = inputIndex;
        }

        @Override
        public int compareTo(Node other) {
            return this.val - other.val;
        }
    }

    private int nthSuperUglyNumber1(int n, int[] primes) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Node(i, primes[i]));
        }
        int[] val = new int[n];
        val[0] = 1;
        for (int i = 1; i < n; ) {
            Node node = pq.poll();
            if (val[i-1] != node.val) {
                val[i] = node.val;
                i++;
            }
            node.index = node.index + 1;
            node.val = primes[node.inputIndex]*val[node.index];
            pq.offer(node);
        }
        return val[n - 1];
    }

    private int ugly(){
        int arr[] = new int[150];
        int count = 1;
        arr[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(count < 150){
            int minNumber = min(arr[i2] * 2, arr[i3] * 3, arr[i5] * 5);
            if(minNumber == arr[i2]*2){
                i2++;
            }
            if(minNumber == arr[i3]*3){
                i3++;
            }
            if(minNumber == arr[i5]*5){
                i5++;
            }
            arr[count++] = minNumber;
        }
        
        return arr[150 -1];
    }
    
    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public static void main(String args[]) {
        UglyNumbers ugly = new UglyNumbers();
        int result = ugly.ugly();
        System.out.println(result);
        int[] primes = {2, 3, 7, 11};
        System.out.print(ugly.nthSuperUglyNumber1(17, primes));
    }
    
}
