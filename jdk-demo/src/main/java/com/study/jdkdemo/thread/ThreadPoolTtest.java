package com.study.jdkdemo.thread;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * shutdown() 方法在终止前允许执行以前提交的任务。
 * shutdownNow() 尝试停止所有正在执行的任务，停止等待任务的处理，并返回等待执行的任务列表。
 */
public class ThreadPoolTtest {
    public static void main(String[] args) {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        ThreadPoolExecutor bossPool = new ThreadPoolExecutor(1, 1, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
        for (int i = 0; i < 20; i++) {
            bossPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bossPool.shutdown();
        bossPool.shutdownNow().forEach(runnable -> System.out.println(runnable));
    }
}
