package codeFights;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 16/07/16.
 */
class TournamentDay40 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static int candies(int n, int m) {
//        return m - m % n;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static ArrayList<Integer> myFilter(ArrayList<Integer> inputArray,
//                                               int extraElement) {
//
//        ArrayList<Integer> result = new ArrayList<>();
//        for (int i = 0; i < inputArray.size(); i++) {
//            if (inputArray.get(i) == extraElement) {
//                continue;
//            }
//            result.add(inputArray.get(i));
//        }
//
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static int chessKnight(String cell) {
//        int row = (cell.toCharArray()[1]) - '0';
//
//        int column = (cell.toCharArray()[0]) - 'a' + 1;
//        int[][] steps = {
//                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
//                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
//        };
//        int answer = 0;
//
//        for (int i = 0; i < steps.length; i++) {
//            int tmpRow = row + steps[i][0];
//            int tmpColumn = column + steps[i][1];
//            if (tmpRow >= 1 && tmpRow <= 8 &&
//                    tmpColumn >= 1 && tmpColumn <= 8)
//                answer += 1;
//        }
//
//        return answer;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static String caesarBoxCipherEncoding(String inputString) {
//
//        int n = (int) Math.sqrt(inputString.length());
//        String ans = "";
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                ans += inputString.charAt(i + j * n);
//            }
//        }
//
//        return ans;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static String myCoffee(int number) {
//        String[] coffees = {"French Roast", "Colombian", "Kona"};
//        return coffees[number - 1];
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static boolean isTournament(int n, int[] from, int[] to) {
//        int[][] adj = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < from.length; j++) {
//                if (i == from[j] - 1)
//                    adj[i][to[j] - 1] = 1;
//            }
//        }
//
//        for (int i = 0; i < adj.length; i++)
//            for (int j = 0; j < adj.length; j++)
//                if (i != j && adj[i][j] == adj[j][i])
//                    return false;
//        return true;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static int maxArray(int[] array, int k) {
        Arrays.sort(array);
        int sum = 0;
        for (int i = array.length - 1; i > array.length - 1 - k && i >= 0; i--)
            sum += array[i];

        return sum == 0 ? 1 : sum;
    }

    private static int maxSumProduct(int[] a, int[] b) {
        int maxProd = 1;
        for (int i = 0; i <= 10; i++) {
            int tmpMax = maxArray(a, i) * maxArray(b, 10 - i);
            if (tmpMax > maxProd)
                maxProd = tmpMax;
        }
        return maxProd;
    }

    public static void main(String[] args) {
        // System.out.println(candies(3, 10));
        // System.out.println(candies(3, 10));
        // System.out.println(chessKnight("a1"));
        // System.out.println(caesarBoxCipherEncoding("a message"));
        // System.out.println(caesarBoxCipherEncoding("a message"));
        // System.out.println(isTournament(5, new int[]{2, 1, 3, 4, 4, 4, 1, 2, 3, 4}, new int[]{3, 2, 1, 3, 2, 1, 5, 5, 5, 5}));
        // System.out.println(maxSumProduct(new int[]{-10, 10, 20, 90}, new int[]{-1, 2, 3, 4, 5}, 5));
        System.out.println(maxSumProduct(new int[]{3, 5, 7}, new int[]{2, 5, 6, 8}));
    }

}
