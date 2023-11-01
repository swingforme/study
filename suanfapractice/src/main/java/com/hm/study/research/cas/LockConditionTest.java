package com.hm.study.research.cas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {

    private final static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();


    public void doSomeThing(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " do Some thing start");
            System.out.println(Thread.currentThread().getName() + " await,release lock");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " weak up");

        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }

    public void getAllThreadUp(){
        lock.lock();
        try {
            System.out.println("get everyone up");
            condition.signalAll();
            System.out.println("everyone up");
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            LockConditionTest t = new LockConditionTest();
            @Override
            public void run() {
                t.doSomeThing();
            }
        }).start();

        Thread.sleep(500);

        new Thread(new Runnable() {
            LockConditionTest t = new LockConditionTest();
            @Override
            public void run() {
                t.getAllThreadUp();
            }
        }).start();
    }
}
