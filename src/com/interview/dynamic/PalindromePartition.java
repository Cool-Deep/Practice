package com.interview.dynamic;

import java.util.*;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 04/03/2016
//// * @author Tushar Roy
//// *
//// * Partitioning the string into palindromes.
//// *
//// * https://leetcode.com/problems/palindrome-partitioning/
//// * https://leetcode.com/problems/palindrome-partitioning-ii/
//// */
////class PalindromePartition {
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    /*
//////     * Given a string s, partition s such that every substring of the partition is a palindrome.
//////     * Return the minimum cuts needed for a palindrome partitioning of s.
//////     * https://leetcode.com/problems/palindrome-partitioning-ii/
//////     */
//////    public int minCut(String str){
//////        if (str.length() == 0) {
//////            return 0;
//////        }
//////
//////        int[] cut = new int[str.length()];
//////        boolean isPal[][] = new boolean[str.length()][str.length()];
//////        for (int i = 1; i < str.length(); i++) {
//////            int min = i;
//////            for (int j = 0; j <= i; j++) {
//////                if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
//////                    isPal[i][j] = true;
//////                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
//////                }
//////            }
//////            cut[i] = min;
//////        }
//////        return cut[str.length() - 1];
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    /**
//////     * Given a string s, partition s such that every substring of the partition is a palindrome.
//////     * https://leetcode.com/problems/palindrome-partitioning/
//////     */
//////    public List<List<String>> partition(String s) {
//////        Map<Integer, List<List<String>>> dp = new HashMap<>();
//////        List<List<String>> result =  partitionUtil(s, dp, 0);
//////        List<List<String>> r = new ArrayList<>();
//////        r.addAll(result);
//////        return r;
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private List<List<String>> partitionUtil(String s, Map<Integer, List<List<String>>> dp, int start) {
////        if (start == s.length()) {
////            List<String> r = new ArrayList<>();
////            return Collections.singletonList(r);
////        }
////
////        if (dp.containsKey(start)) {
////            return dp.get(start);
////        }
////
////        List<List<String>> words = new ArrayList<>();
////        for (int i = start; i < s.length(); i++) {
////            if (!isPalindrome(s, start, i) ) {
////                continue;
////            }
////            String newWord = s.substring(start, i + 1);
////            List<List<String>> result = partitionUtil(s, dp, i + 1);
////            for (List l : result) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//                List<String> l1 = new ArrayList<>();
//                l1.add(newWord);
//                l1.addAll(l);
//                words.add(l1);
//            }
//        }
//        dp.put(start, words);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        return words;
    }

    private  boolean isPalindrome(String str, int r, int t) {
        while(r < t) {
            if (str.charAt(r) != str.charAt(t)) {
                return false;
            }
            r++;
            t--;
        }
        return true;
    }
}
