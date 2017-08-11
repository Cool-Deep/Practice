package com.interview.number;

/**
 * Babylonian method for calculating square root
 */
class SquareRoot {

    private double findRoot(){
        double start =0;
        double end = 144;
        while(Math.abs(start - end) > 0.01){
            end = (start + end)/2;
            start = 144 /end;
        }
        
        return end;
    }
    
    public static void main(String args[]){
        SquareRoot sr = new SquareRoot();
        System.out.println(sr.findRoot());
    }
}
