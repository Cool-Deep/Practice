package codeFights;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Davit on 28/06/16.
 */
class TournamentDay27 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static boolean increaseNumberRoundness(int n) {
//
//        boolean gotToSignificant = false;
//        while (n > 0) {
//            if (n % 10 == 0 && gotToSignificant) {
//                return true;
//            } else if (n % 10 != 0) {
//                gotToSignificant = true;
//            }
//            n /= 10;
//        }
//
//        return false;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static int squareDigitsSequence(int n) {
//
//        int cur = n;
//        Set<Integer> was = new HashSet<>();
//
//        while (!was.contains(cur)) {
//            was.add(cur);
//            int next = 0;
//            while (cur > 0) {
//                next += (cur % 10) * (cur % 10);
//                cur /= 10;
//            }
//            cur = next;
//        }
//
//        return was.size() + 1;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static boolean isFriend(int[] divisors, int a, int b) {
        for (int divisor : divisors)
            if (!(a % divisor == 0 && b % divisor == 0)
                    && !(a % divisor != 0 && b % divisor != 0))
                return false;
        return true;
    }

    private static int numberOfClans(int[] divisors) {
        int clans = 0;
        boolean[] hasFriend = new boolean[10];
        for (int i = 1; i <= 10; i++)
            for (int j = i + 1; j <= 10; j++)
                if (isFriend(divisors, i, j)) {
                    System.out.println("A = " + i + " / B = " + j);
                    hasFriend[i - 1] = true;
                    hasFriend[j - 1] = true;
                    clans++;
                }

        for (int i = 0; i < 10; i++)
            if (!hasFriend[i] && isFriend(divisors, i + 1, i + 1)) {
                System.out.println("A = " + (i + 1));
                clans++;
            }

        return clans;
    }

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    private static int kthDigit(int n, int k) {
//
//        int numDigits = 0, number = n;
//        while (number != 0) {
//            numDigits++;
//            number /= 10;
//        }
//
//        int indexFromLast = numDigits - k + 1;
//
//        while (n != 0) {
//            if (--indexFromLast == 0) {
//                return n % 10;
//            }
//            n /= 10;
//        }
//
//        return -1;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    public static void main(String[] args) {
        // System.out.println(increaseNumberRoundness(902200100));
        // System.out.println(increaseNumberRoundness(902200100));
        // System.out.println(numberOfClans(new int[]{2, 3}, 6));
        System.out.println(numberOfClans(new int[]{1, 3}));
    }

}
