package com.interview.number;

/**
 * GCD greatest common divisor
 * Co prime numbers if GCD of both the numbers is 1
 */
class EuclideanAlgoForGCD {

    private int gcd(int num1, int num2){
        if(num1 > num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while(num1 != 0){
            int temp = num1;
            num1 = num2 % num1;
            num2 = temp;
        }
        return num2;
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    /**
//     * assumption that num1 is less than num2 as initial parameter
//     */
//    private int gcdRec(int num1, int num2){
//        if(num1 == 0){
//            return num2;
//        }
//        return gcdRec(num2%num1, num1);
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    public static void main(String args[]){
        EuclideanAlgoForGCD ea = new EuclideanAlgoForGCD();
        int gcd = ea.gcd(956,1044);
        if(gcd == 1){
            System.out.println("Co prime numbers");
        }else{
            System.out.println("No coprime numbers " + gcd);
        }
    }
}
