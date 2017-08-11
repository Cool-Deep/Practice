package codeFights;

/**
 * Created by Davit on 21/06/16.
 */
class TournamentDay21 {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    static int depositProfit(int deposit, int rate, int threshold) {
//
//        int[] fraction = new int[2];
//        fraction[0] = deposit;
//        fraction[1] = 1;
//        int year = 0;
//
//        while (fraction[0] > threshold) {
//            fraction[0] *= 100 + rate;
//            fraction[1] *= 100;
//            year++;
//        }
//
//        return year;
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private static int visitsOnCircularRoad(int[] visitsOrder) {

        int current = 1,
                res = 0;
        for (int aVisitsOrder : visitsOrder) {
            res += Math.min(Math.abs(aVisitsOrder - current),
                    4 - Math.abs(aVisitsOrder - current));
            current = aVisitsOrder;
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(depositProfit(100, 10, 130));
        System.out.println(visitsOnCircularRoad(new int[]{1, 3, 2, 3, 1}));
    }

}
