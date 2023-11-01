package com.hm.study.search;

/**
 * 无向图 ，二维数组，寻找路径
 */
public class DfsMap {
    /*
      1
 |    |   |
 2    3 - 5
 |
 4
 上图可以看出 1>2>4 , 1>3>5 , 1>5>3
     */

    private int[][] map = new int[][]{
            { 0, 1, 1, 9, 1},
            { 1, 0, 9, 1, 0},
            { 1, 9, 0, 9, 1},
            { 9, 1, 9, 0, 9},
            { 1, 9, 1, 9, 0}
    };
    int[] book = new int[6];
    
    public void play(){
        for (int i = 0; i < map.length; i++) {
            dfs(i);
            System.out.println("");
            book = new int[6];
        }
    }

    /**
     * 从指定的点遍历所有路径
     * @param curr
     */
    private void dfs(int curr){
        int start = curr ;
        int tmp = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[start].length; j++) {
                tmp = map[curr][j];
                if (tmp==0 || tmp==9){
                    continue;
                }
                else {
                    if (book[tmp]==0){
                        book[tmp]==


                    }
                }
            }
            start = (start+1)%map.length;
        }
    }

    public static void main(String[] args) {
test(3);
    }

    private static void test(int a) {
        int start = a ;
        for (int i = 0; i < 5; i++) {
            System.out.print(start+",");
            start = (start+1)%5;
        }
    }
}
