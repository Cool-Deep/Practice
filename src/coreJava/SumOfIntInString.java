package coreJava;

public class SumOfIntInString {

	public static void main(String[] args) {
		String str = "12 hi when 8 and 9 1";
		str = str.replaceAll("[\\D]+", " ");
		String[] numbers = str.split(" ");
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			try {
				sum += Integer.parseInt(numbers[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("The sum is:" + sum);

	}
}
