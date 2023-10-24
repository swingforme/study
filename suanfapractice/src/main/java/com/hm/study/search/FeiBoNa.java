package com.hm.study.search;

/**
 * 有N个台阶，每次可以走一步或两步，请算出一共有多少种走法
 */
public class FeiBoNa {

    private int dfs(int n){

        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        return dfs(n-1)+dfs(n-2);


    }

    /**
     * 带记忆的dfs
     */
    private long[] book = null;
    private long dfsBook(int n){

        book = new long[n+1];
        return dfs2(n);
    }

    private long dfs2(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if (book[n]!=0){
            return book[n];
        }

        long tmp = dfs2(n-1)+dfs2(n-2);
        book[n] = tmp;
        return tmp;
    }

    /**
     * DP dfs 动态规划
     * @param n
     */
    private long dfsDP(int n){

        book = new long[n+1];

        book[1]=1;
        book[2]=2;
        if (n<3){
            return book[n];
        }

        long sum = 0;
        for (int i = 3; i <= n; i++) {
            book[i] = book[i-1] + book[i-2];
        }
        return book[n];

    }


    public static void main(String[] args) {
        FeiBoNa f = new FeiBoNa();
        long start = System.currentTimeMillis();
        System.out.println("there are "+f.dfs(15));
        System.out.println("it talk me "+((System.currentTimeMillis()-start)/1000)+" seconds");

        start = System.currentTimeMillis();
        System.out.println("there are "+f.dfsBook(86));
        System.out.println("it talk me "+((System.currentTimeMillis()-start)/1000)+" seconds");

        start = System.currentTimeMillis();
        System.out.println("there are "+f.dfsDP(5));
        System.out.println("it talk me "+((System.currentTimeMillis()-start)/1000)+" seconds");
    }
}
