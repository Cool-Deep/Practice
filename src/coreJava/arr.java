package coreJava;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

class arr {
	public static void main(String[] args) {
		int[] tab = { 12, 1, 21, 8 };
		
		

		/*for (int i = 0; i < tab.length; i++) {
			int first = tab[i];

		}*/
		IntSummaryStatistics stat = Arrays.stream(tab).summaryStatistics();
		int min = stat.getMin();
		int max = stat.getMax();
		long sum = stat.getSum();
		long count = stat.getCount();
		double average = stat.getAverage();
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);
		System.out.println("sum = " + sum);
		System.out.println("count = " + count);
		System.out.println("average = " + average);
	}

/*	public static int maxValue(char[] chars) {
		int max = chars[0];
		for (int ktr = 0; ktr < chars.length; ktr++) {
			if (chars[ktr] > max) {
				max = chars[ktr];
			}
		}
		return max;
	}*/
}
