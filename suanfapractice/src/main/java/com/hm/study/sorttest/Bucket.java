package com.hm.study.sorttest;

import java.util.Arrays;

/**
 * 桶排序
 */
public class Bucket {

    private static int[] bucket;

    private static void sortThenPrint(int[] arr){
        initBucket(arr);
        insert2Bucket(arr);
        printBucket();
    }

    private static void initBucket(int[] arr){
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("bucket size is "+max);
        bucket = new int[max+1];
    }

    private static void insert2Bucket(int[] arr){
        int score = 0;
        for (int i = 0; i < arr.length; i++) {
            score = arr[i];
            bucket[score] = ++bucket[score];
        }
    }

    private static void printBucket() {
        for (int i = bucket.length-1;i>=0; i--) {
            if (bucket[i]!=0){
                System.out.println(i + " there are " + bucket[i]);
            }
        }
    }

    public static void main(String[] args) {
        sortThenPrint(new int[]{1,1,2,4,5,4,6,7,7,8,9});
    }

}
