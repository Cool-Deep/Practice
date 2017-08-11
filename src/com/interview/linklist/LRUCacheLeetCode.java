package com.interview.linklist;

import java.util.LinkedHashMap;
import java.util.Map;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
///**
// * Date 02/11/2016
// * @author Tushar Roy
// *
// * Reference
// * https://leetcode.com/problems/lru-cache/
// */
//class LRUCacheLeetCode {
//
//    private final LinkedHashMap<Integer,Integer> map;
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public LRUCacheLeetCode(int capacity) {
////        int capacity1 = capacity;
////        this.map = new MyMap(capacity);
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public int get(int key) {
////        Integer val = map.get(key);
////        return val == null ? -1 : val;
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////    public void set(int key, int value) {
////        map.put(key, value);
////    }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    class MyMap extends LinkedHashMap<Integer, Integer> {
        final int capacity;
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//        MyMap(int capacity) {
//            super(capacity, 0.75f, true);
//            this.capacity = capacity;
//        }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
            return size() > capacity;
        }
    }
}
