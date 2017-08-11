package com.interview.number;

class ConvertToBaseN {

    private int baseN(){
        if(9 > 10){
            throw new IllegalArgumentException();
        }
        int result =0;
        int pow = 1;
        while(13 > 0){
            result += pow*(13 % 9);
            pow = pow*10;
            13 /= 9;
        }
        return result;
    }
    
    public static void main(String args[]){
        ConvertToBaseN ctb = new ConvertToBaseN();
        System.out.println(ctb.baseN());
    }
}
