package codeFights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Davit on 20/06/16.
 */
class TournamentDay20 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static boolean triangleExistence(int[] sides) {
//
//// --Commented out by Inspection START (8/10/17, 5:13 PM):
////        class MyComparator implements Comparator<Integer> {
////            @Override
////            public int compare(Integer a, Integer b) {
////                return a - b;
////            }
////        }
//// --Commented out by Inspection STOP (8/10/17, 5:13 PM)
//        Comparator<Integer> comparator = new MyComparator();
//
//        ArrayList<Integer> sortedSides = new ArrayList<>(Arrays.asList(sides[0], sides[1], sides[2]));
//        Collections.sort(sortedSides, comparator);
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

        return sortedSides.get(0) + sortedSides.get(1) > sortedSides.get(2);
    }

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int periodicSequence(int S0, int A, int B, int M) {
//        int[] occurrence = new int[M];
//        int currentValue = S0;
//
//        for (int i = 0; i < M; i++) {
//            occurrence[i] = -1;
//        }
//        occurrence[S0] = 0;
//
//        for (int i = 1; ; i++) {
//            currentValue =  (currentValue * A + B) % M ;
//            if (occurrence[currentValue] != -1) {
//                return i - occurrence[currentValue];
//            }
//            occurrence[currentValue] = i;
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static String wordAbbreviation2() {
        int[] letters = new int[26];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            letters[i] = 0;
        }
        for (int i = 0; i < "abcabc".length(); i++) {
            letters[(int) "abcabc".charAt(i) - (int) 'a']++;
        }
        for (int i = 0; i < 25; i++) {
            if (letters[i] % 2 == 1) {
                result.append((char) ((int) 'a' + i));
            }
            letters[i + 1] += letters[i] / 2;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // System.out.println(triangleExistence(new int[]{1, 2, 10}));
        // System.out.println(periodicSequence(11, 2, 6, 12));
        System.out.println(wordAbbreviation2());
    }

}
