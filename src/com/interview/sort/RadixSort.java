package com.interview.sort;

class RadixSort {

    private void countSort(int arr[],int exp){
        
        int[] count = new int[10];
        int[] output = new int[arr.length];

        for (int anArr : arr) {
            count[(anArr / exp) % 10]++;
        }
        
        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }
        
        for(int i=arr.length-1; i >= 0; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    private int max(int arr[]){
        int max = arr[0];
        for(int i=1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    
    private void radixSort(int arr[]){
        
        int max = max(arr);
        for(int exp = 1; exp <= max; exp *= 10){
            countSort(arr,exp);
        }
    }
    
    public static void main(String args[]){
        int arr[] = {101,10,11,66,94,26,125};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr);
        for (int anArr : arr) {
            System.out.println(anArr);
        }

    }
}
