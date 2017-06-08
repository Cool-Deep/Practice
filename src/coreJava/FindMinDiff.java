package coreJava;

import java.util.Arrays;

public class FindMinDiff {
	public static void main(String[] args) {

		int[] a = { 1, 5, 8, 19, 22, 25 };
		// { 1, 5, 8, 17, 19, 25}

		Arrays.sort(a);
		int minDiff = Integer.MAX_VALUE;
		int maxDiff = a[a.length - 1] - a[0];
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i + 1] - a[i] < minDiff) {
				minDiff = a[i + 1] - a[i];
			}

		}
		System.out.println("min diffrence " + minDiff);
		System.out.println("Max diffrence " + maxDiff);

	}

	static int maxDifference(int[] a) {
		if (a == null || a.length < 1)
			return 0;

		int min = a[0];
		int max = a[0];
		int count = 0;
		for (int i = 1; i <= a.length - 1; i++) {
			if (max < a[i]) {
				max = a[i];
				count++;
			}
		}
		for (int i = 1; i <= count; i++) {

			if (min > a[i]) {
				min = a[i];
			}
		}

		return max - min;
	}

}
