package com.interview.multiarray;

class GameOfLife {

	private boolean [][]board = null;
	private boolean [][]tempBoard = null;
	private GameOfLife(boolean[][] initialState){
		board = initialState;
		tempBoard = new boolean[board.length][board.length];
	}
	
	private void printState(){
        for (boolean[] aBoard : board) {
            for (int j = 0; j < aBoard.length; j++) {
                if (aBoard[j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print("\n");
        }
		System.out.print("\n\n");
	}
	
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//	public void next(){
//
//		int count=0;
//		for(int i=0; i < board.length; i++){
//			for(int j=0; j < board[i].length; j++){
//				count = countNeighbors(i, j);
//				tempBoard[i][j] = board[i][j];
//				if(count <= 1){
//					tempBoard[i][j] = false;
//				}
//				if(count ==3){
//					tempBoard[i][j] = true;
//				}
//				if(count >= 4){
//					tempBoard[i][j] = false;
//				}
//			}
//		}
//		boolean[][] rBoard = tempBoard;
//		tempBoard = board;
//		board = rBoard;
//	}
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

	private void nextOptimized(){
		
		boolean temp1[] = new boolean[board[0].length];
		boolean temp2[] = new boolean[board[0].length];
		calculate(board,temp1,0);
		for(int i=1; i < board.length; i++){
			calculate(board,temp2,i);
			copy(i-1,temp1);
			copy(temp1,temp2);
		}
		copy(board.length-1,temp1);
	}
	
	private void copy(boolean arr1[], boolean arr2[]){
        System.arraycopy(arr2, 0, arr1, 0, arr2.length);
	}
	
	private void calculate(boolean[][] board, boolean temp[], int i){
		int count=0;
		for(int j=0; j < board[i].length; j++){
			count = countNeighbors(i, j);
			temp[j] = board[i][j];
			if(count <= 1){
				temp[j] = false;
			}
			if(count ==3){
				temp[j] = true;
			}
			if(count >= 4){
				temp[j] = false;
			}
		}

	}
	
	private void copy(int i,boolean []temp){
        System.arraycopy(temp, 0, board[i], 0, temp.length);
	}

	private int countNeighbors(int i,int j){
		int count =0;
		for(int k = i-1; k <= i+1; k++){
			for(int l = j-1; l <= j+1; l++){
				if((i ==k && j == l) || k < 0 || l < 0 || k >= board.length || l >= board[k].length){
					continue;
				}
				if(board[k][l]){
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		boolean[][] initialState = new boolean[10][10];
		initialState[3][6] = true;
		initialState[4][6] = true;
		initialState[5][6] = true;
		initialState[5][7] = true;
		initialState[5][8] = true;
		GameOfLife gol = new GameOfLife(initialState);
		gol.printState();
		gol.nextOptimized();
		gol.printState();
		gol.nextOptimized();
		gol.printState();
		gol.nextOptimized();
		gol.printState();
		gol.nextOptimized();
		gol.printState();
		
	}
}
