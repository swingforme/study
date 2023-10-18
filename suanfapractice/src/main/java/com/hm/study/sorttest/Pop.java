package com.hm.study.sorttest;

public class Pop {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,5,11,66,22,2,19,19,0,11,4,5,99,23,12,-9,1,1,2};
        int t=0;
        for (int i=0;i<arr.length;i++){
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]<arr[j]){
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
    }
}
