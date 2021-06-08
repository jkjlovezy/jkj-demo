package com.study.jdkdemo.thread;

import static com.study.jdkdemo.thread.ConcurrentExecutor.mmPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int u = i;
            list.add(() -> {
                System.out.println(Thread.currentThread());
                TimeUnit.SECONDS.sleep(11L);
                return ("a" + u);
            });
        }

        List<Future<String>> futures = mmPool.submit(list);
        futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("InterruptedException");
            } catch (ExecutionException e) {
                //e.printStackTrace();
                System.out.println("ExecutionException");
            } catch (Exception e){
                //e.printStackTrace();
                System.out.println("exception");
            }
            return "";
        }).forEach(System.out::println);
//        TimeUnit.SECONDS.sleep(1L);
        //mmPool.shutdown();
    }

}
