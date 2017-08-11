package com.interview.geometry;

import java.util.HashMap;
import java.util.Map;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 03/21/2016
//// * @author Tushar Roy
//// *
//// * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//// *
//// * Time complexity O(n^2)
//// * Space complexity O(n)
//// *
//// * https://leetcode.com/problems/max-points-on-a-line/
//// */
////class MaximumPointsOnSameLine {
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    static class Point {
//////        final int x;
//////        final int y;
//////        // --Commented out by Inspection (8/10/17, 5:13 PM):Point() { x = 0; y = 0; }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////        // --Commented out by Inspection (8/10/17, 5:13 PM):Point(int a, int b) { x = a; y = b; }
////    }
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    class Pair {
//////        int a;
//////        int b;
//////
//////        @Override
//////        public boolean equals(Object o) {
//////            if (this == o) return true;
//////            if (o == null || getClass() != o.getClass()) return false;
//////
//////            Pair pair = (Pair) o;
//////
//////            if (a != pair.a) return false;
//////            return b == pair.b;
//////
//////        }
//////
//////        @Override
//////        public int hashCode() {
//////            int result = a;
//////            result = 31 * result + b;
//////            return result;
//////        }
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    public int maxPoints(Point[] points) {
//////        int result = 0;
//////        for (int i = 0; i < points.length; i++) {
//////            Map<Pair, Integer> map = new HashMap<>();
//////            int verticalLine = 1;
//////            int onePointMax = 1;
//////            int samePoint = 0;
//////            for (int j = i + 1; j < points.length; j++) {
//////                //same point repeated again. Just increment samePoint count
//////                if (points[i].x == points[j].x && points[i].y == points[j].y) {
//////                    samePoint++;
//////                } else if (points[i].x == points[j].x) { //vertical line
//////                    verticalLine++;
//////                    onePointMax = Math.max(onePointMax, verticalLine);
//////                } else {
//////                    int gcd = gcd(points[i].y - points[j].y, points[i].x - points[j].x);
//////                    Pair p = new Pair();
//////                    p.a = (points[i].y - points[j].y)/gcd;
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////                    p.b = (points[i].x - points[j].x)/gcd;
////                    int count = 2;
////                    if (map.containsKey(p)) {
////                        count = map.get(p);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//                        count++;
//                        map.put(p, count);
//                    } else {
//                        map.put(p, count);
//                    }
//                    onePointMax = Math.max(onePointMax, count);
//                }
//            }
//            result = Math.max(result, onePointMax + samePoint);
//        }
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b, a % b);
    }
}
