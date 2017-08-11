package com.interview.sort;

class CountingSort {

    private static final int TOTAL = 10;

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public void sort(int arr[]) {
//
//        int count[] = new int[TOTAL];
//
//        for (int i = 0; i < arr.length; i++) {
//            count[arr[i]]++;
//        }
//        int c = 0;
//        for (int i = 0; i < TOTAL; i++) {
//            while (count[i] > 0) {
//                arr[c++] = i;
//                count[i]--;
//            }
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private void sort1(int arr[]) {

        int count[] = new int[TOTAL];
        int output[] = new int[arr.length];
        for (int anArr1 : arr) {
            count[anArr1]++;
        }
        
        for(int i=1; i < TOTAL; i++){
            count[i] += count[i-1];
        }

        for (int anArr : arr) {
            output[count[anArr] - 1] = anArr;
            count[anArr]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String args[]) {
        int arr[] = { 6, 1, 6, 7, 3, 1 };
        CountingSort cs = new CountingSort();
        cs.sort1(arr);
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}
