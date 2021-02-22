package com.study.util.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(executor.submit(new MyCallable("name" + i)));
        }

        list.stream().forEach(futrue -> {
            try {
                log.error("{} end", futrue.get());
            } catch (InterruptedException e) {
                log.error("", e);
            } catch (ExecutionException e) {
                log.error("", e);
            }
        });
    }

    static class MyCallable implements Callable<String> {
        private final String name;

        MyCallable(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            log.info("the thread {} is called ", name);
            Thread.sleep(2000L);
            return name;
        }
    }
}
