package com.interview.multiarray;

/**
 * @author malay
 *
 */
class TurnMatrix {

	private void transpose() {

        final int[][] original = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        for (int[] anOriginal1 : original) {
            for (int j = 0; j < anOriginal1.length; j++) {
                System.out.print(anOriginal1[j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n matrix transpose:\n");
        // transpose
        if (original.length > 0) {
            for (int i = 0; i < original[0].length; i++) {
                for (int[] anOriginal : original) {
                    System.out.print(anOriginal[i] + " ");
                }
                System.out.print("\n");
            }
        }
    }
	public static void main(String[] args) {
		TurnMatrix tm = new TurnMatrix();
		tm.transpose();
	}
	
}
