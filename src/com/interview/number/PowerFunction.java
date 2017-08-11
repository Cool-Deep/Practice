package com.interview.number;

/**
 * Date 03/13/2016
 * @author Tushar Roy
 *
 * Find power of 2 numbers.
 *
 * Time complexity O(logn)
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/powx-n/
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 */
class PowerFunction {

    private int power(int n, int m){
        if(m == 0){
            return 1;
        }
        int pow = power(n,m/2);
        if(m % 2 ==0){
            return pow*pow;
        }else{
            return n*pow*pow;
        }
    }


// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public double powerUsingBit(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        long r = n;
//        if (r < 0) {
//            x = 1/x;
//            r = -r;
//        }
//        double power = x;
//        double result = x;
//        double result1 = 1;
//        while (r > 1) {
//            result *= result;
//            if ((r & 1) != 0) {
//                result1 = result1 * power;
//            }
//            r = r >> 1;
//            power = power * power;
//        }
//        return result * result1;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    public static void main(String args[]){
        PowerFunction pf = new PowerFunction();
        long pow = pf.power(3, 5);
        System.out.print(pow);
    }
}
