package com.interview.string;

import java.util.HashMap;
import java.util.Map;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
///**
// * Date 04/15/2016
// * @author Tushar Roy
// *
// * Given a dictionary of words and a word tell if there is unique abbrreviation of this word in the dictionary.
// */
//class ValidWordAbbreviation {
//    private final Map<String, Map<Integer, Integer>> map = new HashMap<>();
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public ValidWordAbbreviation(String[] dictionary) {
////        for (String str : dictionary) {
////            String key = "";
////            int len = 0;
////            if (str.length() > 0) {
////                key = str.charAt(0) + "" + str.charAt(str.length() - 1);
////                len = str.length() - 2;
////            }
////            Map<Integer, Integer> innerMap = map.get(key);
////            if (innerMap == null) {
////                innerMap = new HashMap<>();
////                map.put(key, innerMap);
////            }
////            Integer count = innerMap.get(len);
////            if (count == null) {
////                count = 0;
////            }
////            innerMap.put(len, count + 1);
////        }
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public boolean isUnique(String word) {
////        if (word.length() == 0 || word.length() == 1) {
////            return true;
////        }
////        String key = "";
////        int len = 0;
////        if (word.length() > 0) {
////            key = word.charAt(0) + "" + word.charAt(word.length() - 1);
////            len = word.length() - 2;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        }
//        Map<Integer, Integer> set = map.get(key);
//        if (set == null) {
//            return true;
//        }
//        Integer count = set.get(len);
//        return count == null || count == 1;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
