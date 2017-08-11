package com.interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * References
//// * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
//// */
////class SubtringWithConcatentationOfWords {
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public List<Integer> findSubstring(String s, String[] words) {
//////        Map<String, Integer> actual = new HashMap<>();
//////        Map<String, Integer> used = new HashMap<>();
//////        set(actual, words);
//////        List<Integer> output = new ArrayList<>();
//////        int len = words[0].length();
//////        int count = words.length;
//////        int k = words.length * len;
//////
//////        for (int i = 0; i <= s.length() - k; i++) {
//////            int j = i;
//////            int currentCount = 0;
//////            while (true) {
//////                if(j + len > s.length()) {
//////                    break;
//////                }
//////                String sub = s.substring(j, j + len);
//////                Integer actualCount = actual.get(sub);
//////                if (actualCount != null) {
//////                    Integer usedCount = used.get(sub);
//////                    if ( usedCount == null) {
//////                        usedCount = 0;
//////                    }
//////                    if ( actualCount > usedCount) {
//////                        j = j + len;
//////                        currentCount++;
//////                        used.put(sub, usedCount + 1);
//////                    } else {
//////                        break;
//////                    }
//////                } else {
//////                    break;
//////                }
//////                if ( currentCount == count) {
//////                    break;
//////                }
//////            }
//////            used.clear();
//////            if (currentCount == count) {
//////                output.add(i);
//////            }
//////        }
//////        return output;
//////    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//    private void set(Map<String, Integer> actual, String[] words) {
//        for (String word : words) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
            if (actual.containsKey(word)) {
                actual.put(word,  actual.get(word) + 1);
            } else {
                actual.put(word, 1);
            }
        }
    }
}
