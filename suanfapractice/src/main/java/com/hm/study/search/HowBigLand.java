package com.hm.study.search;

import org.apache.commons.lang3.tuple.Pair;

/**
 * 用dfs或bfs实现一张地图上岛屿数量的识别
 */
public class HowBigLand {

    int size = 0;

    int[][] map = new int[][]{
            {1,0,0,0,0,0,0,0,0,0,0},
            {1,0,1,0,0,0,0,0,0,1,1},
            {0,0,1,1,1,1,0,0,0,1,1},
            {0,0,0,0,1,1,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0}
    };
    int[][] book = new int[map.length][map[0].length];

    Pair<Integer,Integer>[] record = new Pair[map[0].length*map.length];

    int[][] next = new int[][]{{0,1},{0,-1},{-1,0},{1,0} };
    int start=0,end=1;

    public void play(){

      bfs(2,2);

    }

    int tx = 0, ty = 0;

    private void bfs(int x, int y) {
        record[start] = Pair.of(x,y);

        do {

            for (int k = 0; k < 4; k++) {
                tx = record[start].getLeft() + next[k][0];
                ty = record[start].getRight() + next[k][1];

                if (map.length<=tx || tx<0 || map[0].length<=ty || ty<0){
                    continue;
                }

                if (map[x][y]==0){
                    continue;
                }

                if (map[tx][ty] > 0 && book[tx][ty] == 0) {
                    book[tx][ty] = 1;
                    size++;

                    record[end++] = Pair.of(tx,ty);


                }
            }
            start++;
        }while (start<end);
    }

    public static void main(String[] args) {
        HowBigLand hb = new HowBigLand();
        hb.play();
        System.out.println("size is "+ hb.size);
    }
}
