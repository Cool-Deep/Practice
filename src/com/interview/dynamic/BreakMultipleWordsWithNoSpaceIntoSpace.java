package com.interview.dynamic;

import java.util.*;

/**
 * Date 08/01/2014
 * @author tusroy
 * 
 * Given a string and a dictionary, split this string into multiple words such that
 * each word belongs in dictionary.
 * 
 * e.g peanutbutter -> pea nut butter
 * e.g Iliketoplay -> I like to play
 * 
 * Solution 
 * DP solution to this problem
 * if( input[i...j] belongs in dictionary) T[i][j] = i
 * else{
 *     T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 *     
 * Test cases
 * 1) Empty string
 * 2) String where entire string is in dictionary
 * 3) String which cannot be split into words which are in dictionary
 * 3) String which can be split into words which are in dictionary    
 *
 */
class BreakMultipleWordsWithNoSpaceIntoSpace {

    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    /**
//     * Recursive and slow version of breaking word problem.
//     * If no words can be formed it returns null
//     */
//    private String breakWord(char[] str, int low, Set<String> dictionary){
//        StringBuffer buff = new StringBuffer();
//        for(int i= low; i < str.length; i++){
//            buff.append(str[i]);
//            if(dictionary.contains(buff.toString())){
//                String result = breakWord(str, i+1, dictionary);
//                if(result != null){
//                    return buff.toString() + " " + result;
//                }
//            }
//        }
//        if(dictionary.contains(buff.toString())){
//            return buff.toString();
//        }
//        return null;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    /**
     * Dynamic programming version for breaking word problem.
     * It returns null string if string cannot be broken into multipe words
     * such that each word is in dictionary.
     * Gives preference to longer words over splits
     * e.g peanutbutter with dict{pea nut butter peanut} it would result in
     * peanut butter instead of pea nut butter.
     */
    private String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }
        
        //create space separate word from string is possible
        StringBuilder buffer = new StringBuilder();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i, k)).append(" ");
            i = k;
        }
        
        return buffer.toString();
    }

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    /**
//     * Prints all the words possible instead of just one combination.
//     * Reference
//     * https://leetcode.com/problems/word-break-ii/
//     */
//    public List<String> wordBreakTopDown(String s, Set<String> wordDict) {
//        Map<Integer, List<String>> dp = new HashMap<>();
//        int max = 0;
//        for (String s1 : wordDict) {
//            max = Math.max(max, s1.length());
//        }
//        return wordBreakUtil(s, wordDict, dp, 0, max);
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private List<String> wordBreakUtil(String s, Set<String> dict, Map<Integer, List<String>> dp, int start, int max) {
        if (start == s.length()) {
            return Collections.singletonList("");
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> words = new ArrayList<>();
        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            List<String> result = wordBreakUtil(s, dict, dp, i + 1, max);
            for (String word : result) {
                String extraSpace = word.length() == 0 ? "" : " ";
                words.add(newWord + extraSpace + word);
            }
        }
        dp.put(start, words);
        return words;
    }

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    /**
//     * Check if any one solution exists.
//     * https://leetcode.com/problems/word-break/
//     */
//    public boolean wordBreakTopDownOneSolution(String s, Set<String> wordDict) {
//        Map<Integer, Boolean> dp = new HashMap<>();
//        int max = 0;
//        for (String s1 : wordDict) {
//            max = Math.max(max, s1.length());
//        }
//        return wordBreakTopDownOneSolutionUtil(s, wordDict, 0, max, dp);
//
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private boolean wordBreakTopDownOneSolutionUtil(String s, Set<String> dict, int start, int max, Map<Integer, Boolean> dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            if (wordBreakTopDownOneSolutionUtil(s, dict, i + 1, max, dp)) {
                dp.put(start, true);
                return true;
            }
        }
        dp.put(start, false);
        return false;
    }

    
    public static void main(String args[]){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        BreakMultipleWordsWithNoSpaceIntoSpace bmw = new BreakMultipleWordsWithNoSpaceIntoSpace();
        String result1 = bmw.breakWordDP(str, dictionary);
        
        System.out.print(result1);
    }
}
