package coreJava;

import java.util.*;

class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter");
		String A = sc.next();
		StringBuilder br = new StringBuilder(A);
		if (br.reverse().toString().equals(A)) {
			System.out.println("Yes");
		} else
			System.out.println("No");

	}

	 
}