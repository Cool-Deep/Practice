package com.interview.string;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 04/09/2016
//// * @author Tushar Roy
//// *
//// * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//// * For example,
//// * "A man, a plan, a canal: Panama" is a palindrome.
//// * "race a car" is not a palindrome.
//// *
//// * https://leetcode.com/problems/valid-palindrome/
//// */
////class ValidPalindrome {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public boolean isPalindrome(String s) {
//////        int start = 0;
//////        int end = s.length() - 1;
//////        while (start < end) {
//////            if (!isAlphaNum(s.charAt(start))) {
//////                start++;
//////            } else if (!isAlphaNum(s.charAt(end))) {
//////                end--;
//////            } else {
//////                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
//////                    return false;
//////                }
//////            }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////        }
////        return true;
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private boolean isAlphaNum(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}