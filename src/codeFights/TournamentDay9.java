package codeFights;

/**
 * Created by Davit on 08/06/16.
 */
class TournamentDay9 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int minimalMultiple(int divisor, int lowerBound) {
//        if (lowerBound % divisor == 0) {
//            return lowerBound;
//        }
//        return (lowerBound / divisor + 1) * divisor;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int adjacentElementsProduct(int[] inputArray) {
//
//        int best = inputArray[0] * inputArray[1],
//                cur = best;
//        for (int i = 1; i < inputArray.length - 1; i++) {
//            cur = inputArray[i] * inputArray[i + 1];
//            if (best < cur) {
//                best = cur;
//            }
//        }
//
//        return best;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int maxSubarray(int[] inputArray) {
//
//        int max_ending_here = 0, max_so_far = 0;
//        for (int i = 0; i < inputArray.length; i++) {
//            max_ending_here = Math.max(0, max_ending_here + inputArray[i]);
//            max_so_far = Math.max(max_so_far, max_ending_here);
//        }
//        return max_so_far;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int segmentDeletionSlow(int[] left, int[] right) {
//
//        int result = 0;
//
//        for (int i = 0; i < left.length; i++) {
//            int rightBound = left[i];
//            for (int j = 0; j < left.length; j++) {
//                for (int k = 0; k < left.length; k++) {
//                    if (i != k && left[k] <= rightBound && right[k] > rightBound) {
//                        rightBound = right[k];
//                    }
//                }
//            }
//            if (rightBound < right[i]) {
//                result++;
//            }
//        }
//
//        return result;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static boolean coolString() {
        boolean result = false;
        for (int i = 0; i < "wWw1".length(); i++) {
            char chr = "wWw1".charAt(i);
            if (chr >= 'a' && chr <= 'z') {
                if (i != "wWw1".length() - 1
                        && i != 0
                        && ("wWw1".charAt(i + 1) >= 'A' && "wWw1".charAt(i + 1) <= 'Z')
                        && ("wWw1".charAt(i - 1) >= 'A' && "wWw1".charAt(i - 1) <= 'Z')) {
                    result = true;
                } else if (i == 0
                        && ("wWw1".charAt(i + 1) >= 'A' && "wWw1".charAt(i + 1) <= 'Z')) {
                    result = true;
                } else if (i == "wWw1".length() - 1
                        && ("wWw1".charAt(i - 1) >= 'A' && "wWw1".charAt(i - 1) <= 'Z')) {
                    result = true;
                } else {
                    return false;
                }
            } else if (chr >= 'A' && chr <= 'Z') {
                if (i != "wWw1".length() - 1
                        && i != 0
                        && ("wWw1".charAt(i + 1) >= 'a' && "wWw1".charAt(i + 1) <= 'z')
                        && ("wWw1".charAt(i - 1) >= 'a' && "wWw1".charAt(i - 1) <= 'z')) {
                    result = true;
                } else if (i == "wWw1".length() - 1
                        && ("wWw1".charAt(i - 1) >= 'a' && "wWw1".charAt(i - 1) <= 'z')) {
                    result = true;
                } else if (i == 0
                        && ("wWw1".charAt(i + 1) >= 'a' && "wWw1".charAt(i + 1) <= 'z')) {
                    result = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(minimalMultiple(1, 239));
        // System.out.println(adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3}));
        // System.out.println(maxSubarray(new int[]{-1, 7, -2, 3, 4, 0, 1, -1}));
        // System.out.println(segmentDeletionSlow(new int[]{4, 1, 1}, new int[]{7, 3, 6}));
        System.out.println(coolString());
    }

}
