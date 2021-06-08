package com.study.jdkdemo.thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public enum ConcurrentExecutor {
    mmPool {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(200));
        {
            threadPoolExecutor.allowsCoreThreadTimeOut();
        }

        public <T> List<Future<T>> submit(List<Callable<T>> callableList) throws InterruptedException {
            return threadPoolExecutor.invokeAll(callableList, 10, TimeUnit.SECONDS);
        }

        public void shutdown() {
            threadPoolExecutor.shutdown();
        }
    };

    public <T> List<Future<T>> submit(List<Callable<T>> callableList) throws InterruptedException {
        throw new AbstractMethodError();
    }

    public void shutdown() {
        throw new AbstractMethodError();
    }
}

