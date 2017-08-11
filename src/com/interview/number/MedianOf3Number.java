package com.interview.number;

class MedianOf3Number {

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public int median(int arr[]){
//        int l = 0;
//        int h = 2;
//        int m =1;
//
//        if(arr[m] >= arr[l]){
//            if(arr[m] <= arr[h]){
//                return arr[m];
//            }else if(arr[l] >= arr[h]){
//                return arr[l];
//            }
//        }else{
//            if(arr[l] <= arr[h]){
//                return arr[l];
//            }else if(arr[m] >= arr[h]){
//                return arr[m];
//            }
//        }
//        return arr[h];
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

// --Commented out by Inspection START (8/10/17, 5:13 PM):
//    public int median2Comparison(int arr[]){
//        int l = 0;
//        int h = 2;
//        int m =1;
//
//        if((arr[l] - arr[m])*(arr[h] - arr[l]) >= 0){
//            return arr[l];
//        }else if((arr[m] - arr[l])*(arr[h] - arr[m]) >= 0){
//            return arr[m];
//        }else{
//            return arr[h];
//        }
//    }
// --Commented out by Inspection STOP (8/10/17, 5:13 PM)

    private int medianXORMethod(int arr[]){
        int a = arr[0] <= arr[1] ? arr[0] : arr[1];
        int b = arr[1] <= arr[2] ? arr[1] : arr[2];
        int c = arr[0] <= arr[2] ? arr[0] : arr[2];
        return a^b^c;
    }

    public static void main(String args[]){
        MedianOf3Number mn = new MedianOf3Number();
        int arr[] = {2,0,1};
        System.out.println(mn.medianXORMethod(arr));
    }
}
