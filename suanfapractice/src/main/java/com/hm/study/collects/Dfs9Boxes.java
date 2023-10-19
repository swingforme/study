package com.hm.study.collects;

/**
 * 0-9 不能重复的情况下，填写下列的9个格子，让其符合条件
 * xxx + xxx = xxx
 */
public class Dfs9Boxes {

    private int[] rs = new int[9];
    private int[] book = new int[10];

    public void play(){
        dsf(0);
    }

    private void dsf(int step){
        if (step>=rs.length){
            printArray();
            return;
        }
        for (int i = 0; i < book.length; i++) {
            if ((step==3||step==0||step==6)&&i==0)continue;

            if (book[i]==0) {
                book[i]=1;
                rs[step] = i;
                dsf(step+1);
                book[i]=0;
            }
        }
    }

    private void printArray() {
        if ((rs[0]*100+rs[1]*10+rs[2])+(rs[3]*100+rs[4]*10+rs[5])==(rs[6]*100+rs[7]*10+rs[8]))
            System.out.println((rs[0]*100+rs[1]*10+rs[2])+"+"+(rs[3]*100+rs[4]*10+rs[5])+"=="+(rs[6]*100+rs[7]*10+rs[8]));

    }

    public static void main(String[] args) {
        Dfs9Boxes dfs = new Dfs9Boxes();
        dfs.play();
    }
}
