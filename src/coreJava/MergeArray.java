package coreJava;

class MergeArray {

	private static final int[] a= {8, 15, 18, 30, 40};
	private static final int[] b ={10, 11, 20,50,60,70};
	
	private static int[] merge(int[] a, int[] b) {
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
