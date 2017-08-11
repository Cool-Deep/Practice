package com.interview.array;

/**
 * http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
 */
class CheckIfArrayElementsAreConsecutive {

    private boolean areConsecutive(int input[]){
        int min = Integer.MAX_VALUE;
        for (int anInput : input) {
            if (anInput < min) {
                min = anInput;
            }
        }
        for(int i=0; i < input.length; i++){
            if(Math.abs(input[i]) - min >= input.length){
                return false;
            }
            if(input[Math.abs(input[i]) - min] < 0){
                return false;
            }
            input[Math.abs(input[i]) - min] = -input[Math.abs(input[i]) - min];
        }
        for(int i=0; i < input.length ; i++){
            input[i] = Math.abs(input[i]);
        }
        return true;
    }
    
    public static void main(String args[]){
        int input[] = {76,78,76,77,73,74};
        CheckIfArrayElementsAreConsecutive cia = new CheckIfArrayElementsAreConsecutive();
        System.out.println(cia.areConsecutive(input));
    }
}
