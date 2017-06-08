package coreJava;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SumCloseToZero {
	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		sumCloseToZero();
	}

	public static void sumCloseToZero() {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		   //sort //[-80, -10, 1, 60, 70, 85]
		int l = 0;
		int r = arr.length - 1;
		int sum = 0;
		int min_sum = Integer.MAX_VALUE;
		int min_l = l;
		int min_r = r;
		Arrays.sort(arr);
		while (l < r) {
			sum = arr[l] + arr[r];

			/* If abs(sum) is less then update the result items */
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				min_l = l;
				min_r = r;
			}
			if (sum < 0)
				l++;
			else
				r--;
		}

		System.out.printf(
				" The two elements whose sum is minimum are %d and %d",
				arr[min_l], arr[min_r]);
	}

}
