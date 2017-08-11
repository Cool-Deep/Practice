package coreJava;

import java.util.Scanner;

class Square {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		System.out.println(isPowerOfTwo(sc.nextInt()));

	}

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//	private static boolean powerOfTwo(int number) {
//		int square = 1;
//		while (number >= square) {
//			if (number == square) {
//				return true;
//			}
//			square = square * 2;
//		}
//		return false;
//	}
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

	private static boolean isPowerOfTwo(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("number: " + number);
		}
        return (number & -number) == number;
    }

}
