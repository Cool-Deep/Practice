package coreJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class RatInMaze {

	private final int[][] solution;
	private static final List<String> sol = new ArrayList<>();

	//initialize the solution matrix in constructor.
    private RatInMaze(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 1;
			}
		}
	}

	private void solveMaze(int[][] maze, int N) {
		if (findPath(maze, 0, 3, N, "down")) {
			print(solution, N);
		}else{
			System.out.println("NO PATH FOUND");
		}
		
	}

	private boolean findPath(int[][] maze, int x, int y, int N, String direction) {
		// check if maze[x][y] is feasible to move
		if(x==N-2 && y==N-3){//we have reached
			solution[x][y] = 0;
			return true;
		}
		if (isSafeToGo(maze, x, y, N)) {
			// move to maze[x][y]
			solution[x][y] = 0;			
			// now rat has four options, either go right OR go down or left or go up
			
			if(!Objects.equals(direction, "up") && findPath(maze, x+1, y, N, "down")){ //go down
				sol.add("D");
				return true;
			}
			//else go down
			if(!Objects.equals(direction, "left") && findPath(maze, x, y+1, N,"right")){ //go right
				sol.add("R");
				return true;
			}
			if(!Objects.equals(direction, "down") && findPath(maze, x-1, y, N, "up")){ //go up
				sol.add("U");
				return true;
			}
			if(!Objects.equals(direction, "right") &&  findPath(maze, x, y-1, N, "left")){ //go left
				sol.add("L");
				return true;
			}
			//if none of the options work out BACKTRACK undo the move
			solution[x][y] = 1;
			return false;
		}
		return false;
	}

	// this function will check if mouse can move to this cell
    private boolean isSafeToGo(int[][] maze, int x, int y, int N) {
		// check if x and y are in limits and cell is not blocked
        return x >= 0 && y >= 0 && x < N && y < N && maze[x][y] != 1;
    }
	private void print(int[][] solution, int N){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int N = 7;
		int[][] maze = { { 1, 0, 0, 0, 0, 1},
						 { 1, 1, 1, 0, 1, 1}, 
						 { 1, 1, 0, 0, 1, 1},
						 { 1, 1, 0, 0, 1, 1},
						 { 1, 1, 0, 0, 1, 1}, 
						 { 1, 1, 0, 0, 0, 1},
						 { 1, 1, 1, 1, 1, 1}};
		RatInMaze r = new RatInMaze(N);
		r.solveMaze(maze, N);
		System.out.println(sol);
	}

}
