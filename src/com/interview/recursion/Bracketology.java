package com.interview.recursion;

import java.util.Deque;
import java.util.LinkedList;

class Bracketology {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private boolean matchBracket(char str[], int openCount, int pos){
//
//        if(str.length == pos){
//            return openCount == 0;
//        }
//
//        if(str[pos] == '('){
//            openCount++;
//        }else{
//            openCount--;
//        }
//        if(openCount < 0){
//            return false;
//        }
//
//        return matchBracket(str,openCount,pos+1);
//
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private void printArray(char result[]){
        for (char aResult : result) {
            System.out.print(aResult);
        }
        System.out.println();
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private void bracketPermutation(char result[], int n, int pos, int openCount, int closeCount){
//        if(pos == 2*n){
//            printArray(result);
//            return;
//        }
//        if(openCount < n){
//            result[pos] = '(';
//            bracketPermutation(result, n, pos+1,openCount+1,closeCount);
//        }
//        if(closeCount < openCount){
//            result[pos] = ')';
//            bracketPermutation(result, n, pos+1, openCount, closeCount+1);
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private boolean matchBracket(char[] brackets){
        Deque<Character> stack = new LinkedList<>();
        
        for(Character ch : brackets){
            char checkChar = getOpeningCharacter(ch);
            if(checkChar == 0){
                stack.addFirst(ch);
            }else{
                if(stack.size() == 0 || stack.peek() != checkChar){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size() <= 0;

    }
    
    private Character getOpeningCharacter(char ch){
        switch(ch){
            case ')' : return '(';
            case ']' : return '[';
            case '}' : return '{';
            default : return 0;
        }
        
    }

    
    public static void main(String args[]){
        
        Bracketology matcher = new Bracketology();
        //System.out.print(matcher.matchBracket("(())())".toCharArray(), 0, 0));
        int n=4;
        char result[] = new char[n*2];
//      matcher.bracketPermutation(result, n, 0, 0, 0);
        
        System.out.println(matcher.matchBracket("[({()}{}[])]".toCharArray()));
    }
    
    
}
