package com.hm.study.research.cas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private final static Lock lock = new ReentrantLock();

    public void doSomeThing(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " do Some thing start");
            System.out.println(Thread.currentThread().getName() + " await");
//            condition.await();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " weak up");

        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i <2 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LockTest t = new LockTest();
                    t.doSomeThing();
                }
            }).start();
        }
    }
}
