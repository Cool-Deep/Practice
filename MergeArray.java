package coreJava;

public class MergeArray {

	public static int[] a= {8, 15, 18, 30, 40};
	public static int[] b ={10, 11, 20,50,60,70};
	
	public static int[] merge(int[] a, int[] b) {
	    int[] answer = new int[a.length + b.length];
	    int i = a.length - 1, j = b.length - 1, k = answer.length;

	    while (k > 0)
	        answer[--k] = 
	            (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
	           
	    return  answer;
	}

	public static void main(String[] args) {
		//MergeArray m = new MergeArray();
		int[] abc = merge(a, b);
		for(int element: abc){
			System.out.println(element);
		}
	}
}
