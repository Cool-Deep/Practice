package com.interview.multiarray;

/**
 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
class Fill2DMatrixWith1 {

	private void fill(int input[][]){
		boolean row[] = new boolean[input.length];
		boolean col[] = new boolean[input[0].length];
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				if(input[i][j] == 1){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				if(row[i] || col[j]){
					input[i][j] = 1;
				}
			}
		}
	}
	
	public static void main(String args[]){
		int input[][] = {{0,0,1,0,0,0},{0,0,0,0,0,0},{1,0,0,0,0,0}};
		Fill2DMatrixWith1 fd = new Fill2DMatrixWith1();
		fd.fill(input);
        for (int[] anInput : input) {
            for (int j = 0; j < anInput.length; j++) {
                System.out.print(anInput[j] + " ");
            }
            System.out.println();
        }
	}
}
