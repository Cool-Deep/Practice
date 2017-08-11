package codeFights;

import java.util.ArrayList;

/**
 * Created by Davit on 15/06/16.
 */
class TournamentDay16 {

    /*15/06/2016*/

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int countNeighbouringPairs(String inputString) {
//
//        int answer = 0;
//
//        for (int i = 1; i < inputString.length(); i++) {
//            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int swapNeighbouringDigits(int n) {
//
//        int result = 0,
//                tenPower = 1;
//        while (n != 0) {
//            int digit1 = n % 10,
//                    digit2 = ((n - digit1) / 10) % 10;
//            result += tenPower * (10 * digit1 + digit2);
//            n /= 100;
//            tenPower *= 100;
//        }
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    /*static int ballsDistribution(int colors, int ballsPerColor, int boxSize) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int answer = 0;
        int ballsRemaining = 0;
        int colorIdx = 0;
        int row = 0;
        while (colorIdx < colors) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < boxSize; j++) {
                if (ballsRemaining >= ballsPerColor) {
                    colorIdx++;
                    ballsRemaining = 1;
                } else {
                    ballsRemaining++;
                }
                tmp.add(j, colorIdx == colors ? colorIdx - 1 : colorIdx);
                // matrix[row][j] = colorIdx == colors ? colorIdx - 1 : colorIdx;
                if (j - 1 > 0 && tmp.get(j - 1) != tmp.get(j))
                    answer++;
            }
            matrix.add(tmp);
            row++;
        }


        *//*for (int i = 0; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] != matrix[i][j - 1])
                    answer++;*//*

        return answer;
    }*/

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int ballsDistribution(int colors, int ballsPerColor, int boxSize) {
//        int cur = 0,
//                cap = boxSize,
//                res = 0;
//
//        for (int i = 0; i < colors; i++) {
//            int start = cur;
//            for (int j = 0; j < ballsPerColor; j++) {
//                cap--;
//                if (cap == 0) {
//                    cur++;
//                    cap = boxSize;
//                }
//            }
//
//            if (start < cur && cap < boxSize || start + 1 < cur)
//                res++;
//        }
//        return res;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static String simplifyPath(String path) {
//
//        String[] parts = path.split("/");
//        String[] simplified = new String[parts.length];
//        int length = 0;
//        for (String part : parts) {
//            if (part.equals(".") || part.equals("") || part.equals("..")) {
//                if (part.equals("..") && length > 0) {
//                    length--;
//                }
//                continue;
//            }
//            simplified[length] = part;
//            length++;
//        }
//
//        if (length == 0) {
//            return "/";
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            result.append("/" + simplified[i]);
//        }
//
//        return result.toString();
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static int niceFractions() {
        class Helper {
            Helper() {
            }

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//            ArrayList<Integer> toArray(int n) {
//                ArrayList<Integer> num = new ArrayList<>();
//                while (n != 0) {
//                    n /= 10;
//                    num.add(n);
//                }
//                return num;
//            }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

            boolean isFine(int n1, int n2) {
                boolean hasZero = false;
                ArrayList<Integer> digits = new ArrayList<>(5);
                ArrayList<Integer> digits2 = new ArrayList<>(5);

                while (n1 != 0) {
                    for (Integer digit : digits) {
                        if (n1 % 10 == digit)
                            return false;
                    }
                    if (n1 % 10 == 0)
                        hasZero = true;
                    digits.add(n1 % 10);
                    n1 /= 10;
                }

                while (n2 != 0) {
                    for (Integer aDigits2 : digits2) {
                        if (n2 % 10 == aDigits2)
                            return false;
                    }
                    if (n2 % 10 == 0)
                        hasZero = true;
                    digits2.add(n2 % 10);
                    n2 /= 10;
                }

                if (digits2.size() == 4 && hasZero)
                    return false;
                else if (digits2.size() < 4)
                    return false;

                for (Integer digit : digits) {
                    for (Integer aDigits2 : digits2) {
                        if (digit == aDigits2) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        Helper h = new Helper();
        int result = 0;
        for (int i = 12345; i <= 98765; i++) {
            if (i % 8 == 0 && h.isFine(i, i / 8))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(countNeighbouringPairs("aaa"));
        // System.out.println(swapNeighbouringDigits(12345678));
        // System.out.println(ballsDistribution(3, 5, 6));
        // System.out.println(ballsDistribution(10, 10, 9));
        System.out.println(niceFractions());
    }

}
