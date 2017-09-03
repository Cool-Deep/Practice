package coreJava;

import java.io.*;
import java.util.*;

public class ReverseString {
	
	static String reverseMe(String s) {
		   StringBuilder sb = new StringBuilder();
		   for(int i = s.length() - 1; i >= 0; --i)
		     sb.append(s.charAt(i));
		   return sb.toString();
		 }
	
	 static String reverseMeRecursive(String s) {
		   if(s.length() == 0)
		     return "";
		   return s.charAt(s.length() - 1) + reverseMe(s.substring(0,s.length()-1));
		 }
	 
	 String reverse(String s) {
		  int length = s.length();
		  char[] arrayCh = s.toCharArray();
		  for(int i=0; i< length/2; i++) {
		      char ch = s.charAt(i);
		      arrayCh[i] = arrayCh[length-1-i];
		      arrayCh[length-1-i] = ch;
		  } 
		 return new String(arrayCh);
		}
	
 public static void main(String[] args) {
	 
  String input="AliveisAwesome";
  
  System.out.println(reverseMe(input));
  System.out.println(reverseMeRecursive(input));
  
  StringBuilder input1 = new StringBuilder();
  input1.append(input);
  input1=input1.reverse(); 
  System.out.println(input1);
//  for (int i=0;i<input1.length();i++)
//  System.out.print(input1.charAt(i));  
 }}
