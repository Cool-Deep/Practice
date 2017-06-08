package coreJava;

/* Java program to push zeroes to back of array */
import java.io.*;

class PushZero {
	// Function which pushes all zeros to end of an array.
	static void pushZerosToEnd(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is
		// non-zero, then replace the element at index 'count'
		// with this element
		for (int i = 0; i < n; i++)
			if (arr[i] != 1)
				arr[count++] = arr[i]; // here count is
										// incremented

		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < n)
			arr[count++] = 1;
	}
	
	static int[] moveAllOnes(int[] input) {
        int elementCount = input.length;
        int index = 0;  
        for (int i = 0; i < elementCount; i++){
            if (input[i] != 1)  
            	input[index++] = input[i]; 
        } 
            
        while (index < elementCount){
            input[index++] = 1;
        }
        return input;
    }

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		//int arr[] = { 1,2,1,4,5,1,7,8,1,1,9,1};
		int arr[] = { 1,9,8,4,1,1,2,7,1,6,1};

		int n = arr.length;
		moveAllOnes(arr);
		System.out.println("Array after pushing zeros to the back: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}