package com.interview.string;

/**
 * Date 09/22/2014
 * @author tusroy
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
class SubstringSearch {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    /**
//     * Slow method of pattern matching
//     */
//    public boolean hasSubstring(char[] text, char[] pattern){
//        int i=0;
//        int j=0;
//        int k = 0;
//        while(i < text.length && j < pattern.length){
//            if(text[i] == pattern[j]){
//                i++;
//                j++;
//            }else{
//                j=0;
//                k++;
//                i = k;
//            }
//        }
//        return j == pattern.length;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    /**
     * KMP algorithm of pattern matching.
     */
    private boolean KMP(char[] text, char[] pattern){
        
        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return j == pattern.length;
    }
        
    public static void main(String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        SubstringSearch ss = new SubstringSearch();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
        
    }
}
