package com.interview.dynamic;

/**
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
class NumberOfPathsInMxNMatrix {

    private int countPathsRecursive(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        return countPathsRecursive(n-1, m) + countPathsRecursive(n, m-1);
    }
    
// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public int countPaths(int n,int m){
//        int T[][] = new int[n][m];
//        for(int i=0; i < n; i++){
//            T[i][0] = 1;
//        }
//
//        for(int i=0; i < m; i++){
//            T[0][i] = 1;
//        }
//        for(int i=1; i < n; i++){
//            for(int j=1; j < m; j++){
//                T[i][j] = T[i-1][j] + T[i][j-1];
//            }
//        }
//        return T[n-1][m-1];
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    public static void main(String args[]){
        NumberOfPathsInMxNMatrix nop = new NumberOfPathsInMxNMatrix();
        System.out.print(nop.countPathsRecursive(3,3));
    }
    
}
