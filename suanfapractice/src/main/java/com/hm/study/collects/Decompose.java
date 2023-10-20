package com.hm.study.collects;

/**
 * 拆数游戏 2=1+1 ，2+0
 */
public class Decompose {

    private int[] rs = null;
    private int curr;
    public void play(int m){
        rs = new int[m];

        breakdown(m,0);

    }

    private void breakdown(int m, int step) {
        if (m==0 || step>=rs.length){
            printAll(step);
            return;
        }

        for (int i = m; i>0; i--) {

            rs[step] = i;
            breakdown(m-i,step+1);
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
        Decompose d = new Decompose();
        d.play(4);
    }
}
