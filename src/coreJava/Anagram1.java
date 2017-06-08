package coreJava;

import java.util.Arrays;

public class Anagram1 {

	static void isAnagram(String s1, String s2){
		Boolean status = true;
		
		String copyofs1 = s1.replaceAll("\\s", "");
		String copyofs2 = s2.replaceAll("\\s", "");
		
		if (copyofs1.length() != copyofs2.length()){
			status = false;
		}
		else{
			char[] Arrays1 = copyofs1.toLowerCase().toCharArray();
			char[] Arrays2 = copyofs2.toLowerCase().toCharArray();
			
			Arrays.sort(Arrays1);
			Arrays.sort(Arrays2);
			
			status = Arrays.equals(Arrays1, Arrays2);
		}
		
		if(status){
			System.out.println(s1 + " and " + s2 +" are Anagrams");
		}
		else{
			System.out.println(s1 + " and " + s2 +" are not Anagrams");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		isAnagram("Malay is Person", "Malay is erpnos");
		isAnagram("keep", "peek");
		isAnagram("Debit Card", "Bad Credit");
		isAnagram("jshcjs jshfbcjhsf", "wuyiuwbsnb iDUWIWQGDJWBDK");
	}

}
