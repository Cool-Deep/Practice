package com.interview.multiarray;

public class TurnImageBy90 {

	public void turnImage(int [][]mat){
		
		int length = mat.length-1;
		int j=0;
		while(j < mat.length/2){
		
			for(int i=j; i < length-j; i++){
				int temp = mat[j][i];
				mat[j][i] = mat[length-i][j];
				mat[length-i][j] = mat[length-j][length-i];
				mat[length-j][length-i] = mat[i][length-j];
				mat[i][length-j] = temp;
				
			}
			j++;
		}
	}
	
	private void print(int arr[][]){
		for(int i=0; i < arr.length; i++){
			for(int j=0; j < arr.length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String args[]){
		
		int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		TurnImageBy90 ti = new TurnImageBy90();
		ti.turnImage(mat);
		ti.print(mat);
	}
}
