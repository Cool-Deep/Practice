package com.interview.graph;

/**
 * http://en.wikipedia.org/wiki/Flood_fill
 * 
 */
class FloodFillAlgorithm {

    private void fillDFS(int screen[][], int oldColor, int newColor, int startx, int starty){
        fillUtil(screen,startx,starty,oldColor,newColor);
    }
    
    private void fillUtil(int screen[][], int currentx, int currenty, int oldColor, int newColor){
        if(currentx < 0 || currentx >= screen.length || currenty < 0 || currenty >= screen[currentx].length){
            return;
        }
        
        if(screen[currentx][currenty] != oldColor){
            return;
        }
        screen[currentx][currenty] = newColor;
        fillUtil(screen,currentx+1,currenty,oldColor,newColor);
        fillUtil(screen,currentx-1,currenty,oldColor,newColor);
        fillUtil(screen,currentx,currenty+1,oldColor,newColor);
        fillUtil(screen,currentx,currenty-1,oldColor,newColor);
    }
    
    public static void main(String args[]){
        int screen[][] = {{1,1,1,1,1,1},
                    {1,1,1,1,1,1},
                    {1,0,0,1,1,0},
                    {1,1,1,0,0,0},
                    {1,1,1,0,1,0},
                    {1,1,1,1,1,1}};
        FloodFillAlgorithm ff = new FloodFillAlgorithm();
        ff.fillDFS(screen, 0, 2, 3, 3);

        for (int[] aScreen : screen) {
            for (int j = 0; j < aScreen.length; j++) {
                System.out.print(aScreen[j] + " ");
            }
            System.out.println();
        }
    }
}
