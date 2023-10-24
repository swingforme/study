package com.hm.study.search;

/**
 * 用dfs或bfs实现一张地图上岛屿数量的识别
 */
public class HowManyLand {

    int[][] map = new int[][]{
            {1,1,0,0,0,0,0,0,1,1,0},
            {1,1,0,0,0,0,0,0,1,1,0},
            {0,0,0,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,1,1},
            {0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0}
    };
    int[][] book = new int[map.length][map[0].length];

    int[][] next = new int[][]{{0,1},{0,-1},{-1,0},{1,0} };

    public void play(){
        int color = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (map[i][j]>0 && book[i][j]==0){
                    book[i][j]=color;
                    bfs(i,j,color);
                    color++;
                }

            }
        }
    }

    private void bfs(int x, int y,int color) {

        int tx=0,ty=0;
        for (int k = 0; k < 4; k++) {
            tx = x+next[k][0];
            ty = y+next[k][1];

            if (tx >= map.length || tx<0 || ty>=map[0].length || ty<0){
                continue;
            }

            if (map[tx][ty]==0){
                continue;
            }

            if(map[tx][ty]>0 && book[tx][ty]==0){
                book[tx][ty] = color;
                bfs(tx,ty,color);
            }
        }

    }

    private void showArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" , ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HowManyLand hm = new HowManyLand();
        hm.play();
        hm.showArray(hm.book);
    }
}
