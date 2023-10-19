package com.hm.study.collects;

/**
 * 把一组数字的所有排列组合列出来
 */
public class Combinate {

    private String[] str = new String[]{"1","2","3"};

    private String[] rs = new String[str.length];
    int count = 0;

    private void play(int from){
        if (from >= str.length ){
            printArray();
            return;
        }

        for (String c : str) {
            if(!isExists(c,from)) {
                rs[from] = c;
                play(from+1);
            }
        }
    }

    private boolean isExists(String c, int from) {
        for (int i = 0; i < from; i++) {
            if(rs[i].equals(c)){
                return true;
            }
        }
        return false;
    }

    private void printArray() {
        for (String r : rs) {
            System.out.print(r);
        }
        System.out.println();
        count++;
    }

    public static void main(String[] args) {
        Combinate c = new Combinate();
        c.play(0);
        System.out.println("total "+c.count);
    }
}
