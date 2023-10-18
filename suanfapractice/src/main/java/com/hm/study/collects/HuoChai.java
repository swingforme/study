package com.hm.study.collects;

import java.util.List;

/**
 * 火柴棒加法,
 * 火柴数量小于24以内，所以减去 +，= ，最多还剩20 ，最大数为11111
 * A + B = C
 */
public class HuoChai {

    public final int[] arr = new int[]{6,2,5,5,4,5,6,3,7,6};
    public final int max = 1111;

    private int numberCount(int m){
        int count=0;
        while ((m/10) != 0){
            count += arr[m%10];
            m = m/10;
        }

        count += arr[m];

        return count;
    }

    public void possbile(int total){
        total = total - 4;

        for (int i = 0; i <= max; i++) {
            if (numberCount(i)<= (total-4)) {
                for (int j = 0; j <= max; j++) {
                    if ( (numberCount(i)+numberCount(j)+numberCount(i+j))==total){
                        System.out.println(i+"+"+j+"="+(i+j));

                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        HuoChai hc = new HuoChai();
        hc.possbile(18);

    }

}
