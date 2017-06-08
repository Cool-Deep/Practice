package coreJava;

import java.util.ArrayList;
import java.util.List;

public class Merge2Array {
	static int[] arrayC = new int[12];

	public static void main(String[] args) {
		int[] arrayA = { 23, 47, 81, 95, 100 };
		int[] arrayB = { 7, 14, 39, 55, 62, 74, 100 };

		merge(arrayA, arrayA.length, arrayB, arrayB.length);
		for (int i : arrayC) {
			System.out.println(i);

		}
	}

	public static void merge(int[] trendyBusinesses, int sizeA,
			int[] favoriteBusinesses, int sizeB) {
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		int count = 0;
		while (index1 < sizeA && index2 < sizeB)
			if (trendyBusinesses[index1] < favoriteBusinesses[index2]) {
				arrayC[index3++] = trendyBusinesses[index1++];
				count++;
			} else {
				arrayC[index3++] = favoriteBusinesses[index2++];
				count++;
			}

		while (index1 < sizeA) {
			arrayC[index3++] = trendyBusinesses[index1++];
			count++;
		}

		while (index2 < sizeB) {
			arrayC[index3++] = favoriteBusinesses[index2++];
			count++;
		}
		System.out.println("count " + count);
		// Arrays.sort(arrayC);
	}

	public static void merge(List<Integer> trendyBusinesses,
			List<Integer> favoriteBusinesses) {
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		int count = 0;
		List<Integer> result = new ArrayList<Integer>();
		while (index1 < trendyBusinesses.size()
				&& index2 < favoriteBusinesses.size()) {
			if (trendyBusinesses.get(index1) < favoriteBusinesses.get(index2)) {
				result.add(trendyBusinesses.get(index1++));
			} else {
				result.add(favoriteBusinesses.get(index2++));
			}
		}

		while (index1 < trendyBusinesses.size()) {
			result.add(trendyBusinesses.get(index1++));
		}

		while (index2 < favoriteBusinesses.size()) {
			result.add(favoriteBusinesses.get(index2++));
		}
	}
}