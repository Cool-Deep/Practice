package com.interview.dynamic;

/**
 * Finding the number of ways a given score could be reached for a game with 3 different ways of scoring (e.g. 3, 5 and 10 points).
 *test case
 *what happens if total can't be formed with given values
 *what if numbers are 0 or negative
 */
class NumberOfWaysToScorePoints {

    //in this version to make 3 - 1,2 is same as 2,1.
    //This is similar to coin changing problem
    private int version1(int score[], int total){
        int T[] = new int[total+1];
        T[0] = 1;
        for (int aScore : score) {
            for (int j = 1; j <= total; j++) {
                if (aScore <= j) {
                    T[j] += T[j - aScore];
                }
            }
        }
        return T[total];
    } 
    
    //in this version to make 3 - 1,2 and 2,1 are counted different.
    //This is same as fibo series only that fibo series looks at last 2 numbers and here we look back k values
    private int version2(int score[], int total){
        int T[] = new int[total+1];
        T[0] = 1;
        for(int i=1; i <= total ; i++){
            for (int aScore : score) {
                if (aScore <= i) {
                    T[i] += T[i - aScore];
                }
            }
        }
        return T[total];
    }
    
    public static void main(String args[]){
        int score[] = {1,2,3};
        NumberOfWaysToScorePoints now = new NumberOfWaysToScorePoints();
        System.out.println(now.version1(score, 4));
        System.out.println(now.version2(score, 4));
    }
}
