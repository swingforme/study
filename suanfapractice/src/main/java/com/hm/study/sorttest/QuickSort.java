package com.hm.study.sorttest;

public class QuickSort {

    private int[] arr;

    public void sort(int[] arr){
        this.arr = arr;

        int i = 0;
        int j = this.arr.length-1;

        sort(i,j);

    }

    private void sort(final int left, final int right){
        if (left >= right){
            return;
        }

        int aim = arr[left];
        int idxL = left;
        int idxR = right;

        while (idxR > idxL) {
            for (; idxR > idxL; idxR--) {
                if (arr[idxR] <= aim) {
                    break;
                }
            }

            for (; idxL < idxR; idxL++) {
                if (arr[idxL] > aim) {
                    break;
                }
            }

            if (idxL < idxR) {
                int tmp = arr[idxR];
                arr[idxR] = arr[idxL];
                arr[idxL] = tmp;
            } else {
                int tmp = arr[idxR];
                arr[idxR] = arr[left];
                arr[left] = tmp;
                break;
            }
        }

        sort(left, idxR-1);
        sort(idxR+1,right);
    }



    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{11,88,33,33,2,4,1,6,6,1,4,3,3,5,2,1,6};
        qs.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
    }
}
