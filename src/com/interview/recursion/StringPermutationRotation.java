package com.interview.recursion;

class StringPermutationRotation {

    private void swap(char arr[],int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    
    private void printArray(char str[]){
        for (char aStr : str) {
            System.out.print(aStr);
        }
        System.out.print("\n");
    }
    
    private void permute(char[] str, int pos){
        if(pos == str.length){
            printArray(str);
            return;
        }
        for(int i=pos; i < str.length; i++){
            swap(str,pos,i);
            permute(str,pos+1);
            swap(str,pos,i);
        }
    }
    
    public static void main(String args[]){
        String str = "ABC";
        StringPermutationRotation sp = new StringPermutationRotation();
        sp.permute(str.toCharArray(),0);
    }
}
