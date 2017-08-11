package com.interview.bits;

class Pair{
    int x;
    int y;
}

/**
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 */
class MissingNumbers {

    private Pair findMissingAndRepeated(int arr[], int n){
        int xor = 0;
        for (int anArr1 : arr) {
            xor = xor ^ anArr1;
        }
        
        for(int i=1; i <= n; i++){
            xor = xor ^ i;
        }
        
        xor = xor & ~(xor-1);
        int set1 = 0;
        int set2 = 0;
        for (int anArr : arr) {
            if ((anArr & xor) > 0) {
                set1 ^= anArr;
            } else {
                set2 ^= anArr;
            }
        }
        Pair p = new Pair();
        for(int i=1; i <= n; i++){
            if((i & xor) > 0){
                set1 ^= i;
            }else{
                set2 ^= i;
            }
        }
        p.x = set1;
        p.y = set2;
        return p;
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public Pair findTwoMissingNumber(int arr[], int n){
//        int xor = 0;
//        for(int i=0; i < arr.length; i++){
//            xor = xor ^ arr[i];
//        }
//
//        for(int i=1; i <= n; i++){
//            xor = xor ^ i;
//        }
//
//        xor = xor & ~(xor-1);
//        int set1 = 0;
//        int set2 = 0;
//        for(int i=0; i < arr.length; i++){
//            if((arr[i] & xor) > 0){
//                set1 ^= arr[i];
//            }else{
//                set2 ^= arr[i];
//            }
//        }
//        Pair p = new Pair();
//        for(int i=1; i <= n; i++){
//            if((i & xor) > 0){
//                set1 ^= i;
//            }else{
//                set2 ^= i;
//            }
//        }
//        p.x = set1;
//        p.y = set2;
//        return p;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    public static void main(String args[]){
        MissingNumbers mn = new MissingNumbers();
        int arr[] = {1,2,3,5,5};
        Pair p = mn.findMissingAndRepeated(arr, 5);
        System.out.println(p.x + " " + p.y);
        int arr1[] = {1,5,3,6};
        p = mn.findMissingAndRepeated(arr1, 6);
        System.out.println(p.x + " " + p.y);
    }
}
