package com.interview.bits;

/**
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 * http://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 */
public class NumberOccuringOddTimes {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public int oneNumberOccuringOddTimes(int arr[]){
//        int r = 0;
//        for(int i=0; i < arr.length; i++){
//            r = r^arr[i];
//        }
//        return r;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    class Pair{
        int a;
        int b;
        
    }
    
    private Pair twoNumbersOccuringOddTimes(int arr[]){
        int r = 0;
        for (int anArr1 : arr) {
            r = r ^ anArr1;
        }
    
        r = r & ~(r-1);
        int r1 = 0;
        int r2 = 0;
        for (int anArr : arr) {
            if ((r & anArr) == 0) {
                r1 = r1 ^ anArr;
            } else {
                r2 = r2 ^ anArr;
            }
        }
        Pair p = new Pair();
        p.a = r1;
        p.b = r2;
        return p;
    }
    
    public static void main(String args[]){
        NumberOccuringOddTimes noot = new NumberOccuringOddTimes();
        int arr[] = {1,2,9,9,2,1,9,7,2,1,9,1};
        Pair p = noot.twoNumbersOccuringOddTimes(arr);
        System.out.print(p.a + " " + p.b);
    }
}

