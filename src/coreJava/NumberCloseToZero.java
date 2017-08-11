package coreJava;

class NumberCloseToZero {
	public static void main(String[] args) {
		int myNumber = 0;
		int[] numbers = { -10, 10, 9, 8, -12, -12, -2, -2, 1};
		System.out.println("close2Zero "+closest1(0,numbers));
		int distance = Math.abs(numbers[0] - myNumber);
		int idx = 0;
		for (int c = 1; c < numbers.length; c++) {
			int cdistance = Math.abs(numbers[c] - myNumber);
			if (cdistance < distance) {
				idx = c;
				distance = cdistance;
			}
		}
		int theNumber = numbers[idx];
		System.out.println(theNumber);
	}
	
	
	private static int closest1(int find, int[] values) {
	    int closest = values[0];
	    for(int value: values)
	       if(Math.abs(closest - find) > Math.abs(value - find))
	           closest = value;
	    return closest;
	}
}
