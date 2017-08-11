package codeFights;

import java.util.ArrayList;

/**
 * Created by Davit on 13/06/16.
 */
class TournamentDay14 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static boolean isCaseInsensitivePalindrome(String inputString) {
//
//        for (int i = 0; i < inputString.length() / 2; i++) {
//            char[] c = {
//                    inputString.charAt(i),
//                    inputString.charAt(inputString.length() - i - 1)
//            };
//            for (int j = 0; j < 2; j++) {
//                if (c[j] >= 'a' && c[j] <= 'z') {
//                    c[j] = (char) (c[j] - 'a' + 'A');
//                }
//            }
//            if (c[0] != c[1]) {
//                return false;
//            }
//        }
//
//        return true;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static boolean higherVersion() {
        class Helper {
            Helper() {

            }

            ArrayList<Integer> toArray(String str) {
                ArrayList<Integer> result = new ArrayList<>();
                StringBuilder num1 = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '.') {
                        result.add(Integer.parseInt(num1.toString()));
                        num1 = new StringBuilder();
                    } else {
                        num1.append(str.charAt(i));
                    }
                }
                result.add(Integer.parseInt(num1.toString()));
                return result;
            }
        }

        Helper h = new Helper();
        ArrayList<Integer> num1 = h.toArray("1.10.2");
        ArrayList<Integer> num2 = h.toArray("1.2.10");

        for (int i = 0; i < num1.size(); i++) {
            if (num1.get(i) < num2.get(i))
                return false;
            else if (num1.get(i) > num2.get(i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(isCaseInsensitivePalindrome("AaBaa"));
        System.out.println(higherVersion());
    }

}
