package coreJava;

class SumOfIntInString {

	public static void main(String[] args) {
		String str = "12 hi when 8 and 9 1";
		str = str.replaceAll("[\\D]+", " ");
		String[] numbers = str.split(" ");
		int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

		System.out.println("The sum is:" + sum);

	}
}
