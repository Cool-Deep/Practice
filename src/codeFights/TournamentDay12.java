package codeFights;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 11/06/16.
 */
class TournamentDay12 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int smallestMultiple(int left, int right) {
//        int result = right;
//        int k = 0;
//        while (k < right * left) {
//            for (int i = left; i <= right; i++) {
//                if (result % i != 0) {
//                    result++;
//                    break;
//                } else {
//                    k++;
//                }
//            }
//        }
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static String[] isDivisibleBy6() {

        ArrayList<String> ar = new ArrayList();
        for (char c = '0'; c <= '9'; c++) {

            String s = "1*0".replace('*', c);
            try {
                if (Long.parseLong(s) % 6 == 0) {
                    ar.add(s);
                }
            } catch (Exception e) {

            }
        }

        return ar.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // System.out.println(smallestMultiple(2, 4));
        System.out.println(Arrays.toString(isDivisibleBy6()));
    }

}
