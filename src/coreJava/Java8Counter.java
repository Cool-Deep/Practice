package coreJava;

import java.util.Scanner;

public class Java8Counter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter string");
		String s = sc.nextLine();
		String[] words = s.split(" ");  
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}

	}
}