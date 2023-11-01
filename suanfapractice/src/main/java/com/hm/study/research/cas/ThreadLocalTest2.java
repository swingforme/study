package com.hm.study.research.cas;

import java.util.ArrayList;
import java.util.List;

class ThreadLocalMemoryLeakDemo {
    private static ThreadLocal<List<byte[]>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建一个线程，并启动
        Thread thread = new Thread(() -> {
            // 分配大量的内存作为线程本地变量
            List<byte[]> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                byte[] bytes = new byte[1024 * 1024]; // 1MB
                data.add(bytes);
            }

            // 将线程本地变量设置到ThreadLocal中
            threadLocal.set(data);

            // 执行一些逻辑...

            // 不再使用线程本地变量，但没有清除
            // threadLocal.set(null); // 可以手动清除，避免内存泄漏
        });

        thread.start();

        // 等待线程执行完成
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 在主线程中，尝试获取线程本地变量
        List<byte[]> retrievedData = threadLocal.get();
        System.out.println("Retrieved Data: " + retrievedData);
    }
}