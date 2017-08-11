package coreJava;

class ReverseIntArray {
	public static void main(String[] args) {
		int[] array = { 5, 2, 3, 7, 9,0,-6,8,6,4 };
		 reverse(array);
//		for (int i = 0; i < array.length / 2; i++) {
//			int temp = array[i];
//			array[i] = array[array.length - 1 - i];
//			array[array.length - 1 - i] = temp;
//		}

        for (int anArray : array) {
            System.out.println(anArray);
        }
	}
	
	private static void reverse(int[] data) {
	    int left = 0;
	    int right = data.length - 1;
	    int count=0;
	    while( left < right ) {
 	        int temp = data[left];
	        data[left] = data[right];
	        data[right] = temp;

 	        left++;
	        right--;
	        count++;
	    }
	    System.out.println("Count  "+count);
    }
}
