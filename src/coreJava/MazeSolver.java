package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//Consider a rat in a maze. There is only one entry and one exit. 

//There are blocks in its path and it can easily take a wrong route. 
//Find a path from the entry to the exit.


class MazeSolver {

	private static final String WALL_CHAR = "#";
	// --Commented out by Inspection (8/10/17, 5:13 PM):public static final String FREE_CHAR = " ";
	private static final String PATH_CHAR = "*";
	private static final String START_CHAR = "S";
	private static final String FINISH_CHAR = "F";

	private static Point startPoint = null;
	private static Point endPoint = null;
	private static String[][] maze = null;
	private static final List<String> sol = new ArrayList<>();
	public static void main(String[] args) {
		new MazeSolver();
		Collections.reverse(sol);
		System.out.println(sol);
	}

	private MazeSolver() {
		maze = createMaze();

		printMaze();

		startPoint = getXAndYOf(maze, START_CHAR);
		endPoint = getXAndYOf(maze, FINISH_CHAR);

		if (startPoint == null || endPoint == null) {
			System.out.println("No start or end point found");
		} else {
			boolean status = findRoute(MazeSolver.startPoint);
			if (status) {
				System.out.println("Route Found....\n");
				printMaze();
			} else {
				System.out.println("Route Not Found.");
			}
		}
	}

	private void printMaze() {
        for (String[] aMaze : maze) {
            for (int j = 0; j < aMaze.length; j++) {
                System.out.print(aMaze[j]);
            }
            System.out.println();
        }
	}

	private boolean findRoute(Point workingPoint) {

		// Check if x and y don't cross boundaries while working on
		// circumference
		if (workingPoint.x < 0 || workingPoint.x > maze.length || workingPoint.y < 0
				|| workingPoint.y > maze[workingPoint.x].length) {
			return false;
		}

		// Check if current working point is not a wall or already visited
		if (Objects.equals(maze[workingPoint.x][workingPoint.y], WALL_CHAR) || Objects.equals(maze[workingPoint.x][workingPoint.y], PATH_CHAR)) {
			return false;
		}

		// Check if we reached the end point.
		if (Objects.equals(maze[workingPoint.x][workingPoint.y], FINISH_CHAR)) {
			return true;
		}

		// Mark the current point as visited.
		maze[workingPoint.x][workingPoint.y] = PATH_CHAR;

		// From Current point, solution can be in any of 4 direction. So start
		// looking in all 4 direction

		// SOUTH
		if (findRoute(new Point(workingPoint.x + 1, workingPoint.y))) {
			sol.add("D");
			return true;
		}

		// WEST
		if (findRoute(new Point(workingPoint.x, workingPoint.y + 1))) {
			sol.add("R");
			return true;
		}

		// EAST
		if (findRoute(new Point(workingPoint.x, workingPoint.y - 1))) {
			sol.add("L");
			return true;
		}

		// NORTH
		if (findRoute(new Point(workingPoint.x - 1, workingPoint.y))) {
			sol.add("U");
			return true;
		}
		return false;
	}

	// Return the x and y coordinate of choice in Maze if present else null
	private Point getXAndYOf(String[][] maze, String choice) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (Objects.equals(maze[i][j], choice)) {
					return new Point(i, j);
				}
			}
		}
		return null;
	}

	// Function to create Maze
    private String[][] createMaze() {
		String maze[][] = { { "#", "#", "#", "#", "#", "#", "#"},
							{ "#", "#", "S", " ", " ", " ", "#"},
							{ "#", "#", "#", " ", "#", " ", "#"},
							{ "#", "#", "#", " ", "#", " ", "#"},
							{ "#", "#", " ", " ", "#", " ", "#"},
							{ "#", "#", " ", "#", "#", "#", "#"},
							{ "#", "#", " ", " ", " ", "F", "#"},
							{ "#", "#", "#", "#", "#", "#", "#"} };
		return maze;
	}
}

/*
 * Class to store x and y coordinate of each cell in maze
 */
class Point {
	public final int x;
	public final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
