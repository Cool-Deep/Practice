package com.interview.multiarray;

/**
 * http://www.careercup.com/question?id=6685828805820416
 * Test Edge cases
 * Values in cell should be in range of 2D array.
 */
class Cell{
	final int x;
	final int y;
	Cell(int x,int y){
		this.x = x;
		this.y = y;
	}
}

class MoveCellPerCellValue {

	private boolean isAllCellTraversed(Cell grid[][]){
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		int total = grid.length * grid[0].length;
		int startx = grid[0][0].x;
		int starty = grid[0][0].y;
		for(int i=0; i < total-2; i++){
			if(grid[startx][starty] == null){
				return false;
			}
			if(visited[startx][starty]){
				return false;
			}
			visited[startx][starty] = true;
			int x = grid[startx][starty].x;
			int y = grid[startx][starty].y;
			startx = x;
			starty = y;
		}
        return grid[startx][starty] == null;
    }
	
	public static void main(String args[]){
		Cell cell[][] = new Cell[3][2];
		cell[0][0] = new Cell(0,1);
		cell[0][1] = new Cell(2,0);
		cell[1][0] = null;
		cell[1][1] = new Cell(1,0);
		cell[2][0] = new Cell(2,1);
		cell[2][1] = new Cell(1,1);
		
		MoveCellPerCellValue mcp = new MoveCellPerCellValue();
		System.out.println(mcp.isAllCellTraversed(cell));
	}
}
