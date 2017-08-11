package com.interview.array;

import java.util.Arrays;
import java.util.PriorityQueue;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 05/01/2016
//// * @author Tushar Roy
//// *
//// * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
//// * find the minimum number of conference rooms required.
//// *
//// * Both methods have time comlexity of nlogn
//// * Method 1 has space complexity of O(1)
//// *
//// * https://leetcode.com/problems/meeting-rooms-ii/
//// */
////class MeetingRooms {
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public static class Interval {
//////          final int start;
//////          final int end;
//////          // --Commented out by Inspection (8/10/17, 5:13 PM):Interval() { start = 0; end = 0; }
//////          // --Commented out by Inspection (8/10/17, 5:13 PM):Interval(int s, int e) { start = s; end = e; }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////    }
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int minMeetingRooms1(Interval[] intervals) {
//////        int[] start = new int[intervals.length];
//////        int[] end = new int[intervals.length];
//////
//////        for (int i = 0; i < intervals.length; i++) {
//////            start[i] = intervals[i].start;
//////            end[i] = intervals[i].end;
//////        }
//////
//////        Arrays.sort(start);
//////        Arrays.sort(end);
//////
//////        int j = 0;
//////        int rooms = 0;
//////        for (int i = 0; i < start.length; i++) {
//////            if (start[i] < end[j]) {
//////                rooms++;
//////            } else {
//////                j++;
//////            }
//////        }
//////        return rooms;
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int minMeetingRooms(Interval[] intervals) {
//////        if (intervals.length == 0) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////            return 0;
////        }
////        Arrays.sort(intervals, (a, b) ->  a.start - b.start);
////        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        pq.offer(intervals[0]);
//        int rooms = 1;
//        for (int i = 1; i < intervals.length; i++) {
//            Interval it = pq.poll();
//            if (it.end <= intervals[i].start) {
//                it = new Interval(it.start, intervals[i].end);
//            } else {
//                rooms++;
//                pq.offer(intervals[i]);
//            }
//            pq.offer(it);
//        }
//        return rooms;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
