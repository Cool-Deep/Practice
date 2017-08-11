package com.interview.string;

import java.util.ArrayList;
import java.util.List;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
// --Commented out by Inspection START (8/10/17, 5:13 PM):
/////**
//// * Date 04/06/2016
//// * @author Tushar Roy
//// *
//// * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
//// * and is decoded back to the original list of strings.
//// *
//// * Reference
//// * https://leetcode.com/problems/encode-and-decode-strings/
//// */
////class StringEncoderDecoder {
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    // Encodes a list of strings to a single string.
//////    public String encode(List<String> strs) {
//////        StringBuffer buff = new StringBuffer();
//////        for (String str : strs) {
//////            String size = toFixedLength(str.length());
//////            buff.append(size);
//////            buff.append(str);
//////        }
//////        return buff.toString();
//////    }
////// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////
////    private String toFixedLength(int len) {
////        StringBuffer buff = new StringBuffer();
////        for (int i = 0; i < 4; i++) {
////            char b1 = (char) len;
////            buff.append(b1);
////            len = len >> 8;
////        }
////        return buff.toString();
////    }
////
////    private int toSize(String str) {
////        int val = 0;
////        for (int i = str.length() - 1; i > 0; i--) {
////            val += str.charAt(i);
////            val = val << 8;
////        }
////        val += str.charAt(0);
////        return val;
////    }
////
////// --Commented out by Inspection START (8/10/17, 5:13 PM):
//////    // Decodes a single string to a list of strings.
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
////    public List<String> decode(String s) {
////        List<String> result = new ArrayList<>();
////        while (s.length() != 0) {
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//            int size = toSize(s.substring(0, 4));
//            result.add(s.substring(4, size + 4));
//            s = s.substring(size + 4);
//        }
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
}
