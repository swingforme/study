package com.hm.study.research.cas;

public class ThreadLocalTest {
    private static ThreadLocal<String> tl1 = new ThreadLocal<>();
    private static ThreadLocal<String> tl2 = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest tt = new ThreadLocalTest();
                tt.tl1.set("11");
                tt.tl2.set("12");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 key value is "+tt.tl1.get());
                System.out.println("thread1 key value is "+tt.tl2.get());
            }
        });
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest tt = new ThreadLocalTest();
                tt.tl1.set("22");
                tt.tl2.set("23");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 key value is "+tt.tl1.get());
                System.out.println("thread2 key value is "+tt.tl2.get());
            }
        });
        t2.start();



    }
}
