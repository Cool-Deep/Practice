package com.interview.number;

/**
 * http://www.geeksforgeeks.org/lucky-numbers/
 */
class LuckyNumbers {

    private boolean isLuck(int n, int counter) {
        if (n < counter) {
            return true;
        }
        return n % counter != 0 && isLuck(n - n / counter, counter + 1);

    }
    
    public static void main(String args[]){
        LuckyNumbers ln = new LuckyNumbers();
        System.out.println(ln.isLuck(19, 2));
    }
    
}
