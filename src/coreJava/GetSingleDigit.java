package coreJava;

import java.util.*;

public class GetSingleDigit {

	public static void main(String[] args) {

		String n = "6321";

		int n1 = Integer.parseInt(n);

		System.out.println(reduceToOneDigit(n1));
	}

	public static int reduceToOneDigit(int n1) {
		int result = 1;
		while (n1 > 9) {
			while (n1 > 0) {
				result *= (n1 % 10);
				n1 /= 10;
			}
			n1=result;
			result=1;
		}
		return n1;
	}
}
