package com.hm.study.collects;

/**
 * 拆数游戏 2=1+1 ，2+0
 * 相比第一种，这个多了一个from参数
 */
public class DecomposeNoRepeat {

    private int[] rs = null;
    private int curr;
    public void play(int m){
        rs = new int[m];

        breakdown(m,0, 1);

    }

    private void breakdown(int m, int step, int from) {
        if (m==0 || step>=rs.length){
            printAll(step);
            return;
        }

        for (int i = from; i<=m; i++) {

            rs[step] = i;
            breakdown(m-i,step+1,i);
        }

    }

    private void printAll(int idx) {
        System.out.print(rs[0]);
        for (int i = 1; i < idx; i++) {
            System.out.print("+"+rs[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DecomposeNoRepeat d = new DecomposeNoRepeat();
        d.play(4);
    }
}
