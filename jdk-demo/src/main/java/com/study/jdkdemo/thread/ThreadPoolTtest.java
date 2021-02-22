package com.study.jdkdemo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTtest {
    public static void main(String[] args) {
        ThreadPoolExecutor bossPool = new ThreadPoolExecutor(1, 1, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
        for (int i = 0; i < 5; i++) {
            bossPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
