package com.hm.study.collects;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 小猫钓鱼，运用stack的特性，在游戏开始推断谁赢谁输
 */
public class Puke {

    private final static Stack<Integer> user1 = new Stack();
    private final static Stack<Integer> user2 = new Stack();
    private final static Stack<Integer> table = new Stack();

    private void initTwoUserPuke(){
        int[] p1 = new int[]{1,3,4,2,5,6};
        List<Integer> p1List = IntStream.of(p1).boxed().collect(Collectors.toList());
        user1.addAll(p1List);

        int[] p2 = new int[]{3,1,5,6,2,4};
        List<Integer> p2List = IntStream.of(p2).boxed().collect(Collectors.toList());
        user2.addAll(p2List);
    }

    public void play(){
        initTwoUserPuke();
        List winList = null;

        while(!user1.isEmpty() && !user2.isEmpty()){

            playACard(user1);

            playACard(user2);

        }
        System.out.println("user1 is "+ (user1.isEmpty()?"winner":"loser"));
        System.out.println("user2 is "+ (user2.isEmpty()?"winner":"loser"));
    }


    private void playACard(Stack<Integer> user) {
        Integer nextCard = user.pop();

        if (table.indexOf(nextCard)>-1){
            user.insertElementAt(nextCard,0);

            Integer tmp = 0;
            do {
                tmp=table.pop();
                user.insertElementAt(tmp,0);
            }while (tmp!=nextCard);

        }else{
            table.add(nextCard);
        }
    }


    public static void main(String[] args) {
        Puke pk = new Puke();
        pk.play();

    }
}
