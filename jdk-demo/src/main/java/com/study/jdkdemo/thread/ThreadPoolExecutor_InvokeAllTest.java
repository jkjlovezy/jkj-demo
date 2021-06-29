package com.study.jdkdemo.thread;

import static com.study.jdkdemo.thread.ExecutorPool.mmPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 批量提交task，并设置task的timeout， timeout是从submit的时间开始算起，若是ThreadPoolExecutor中的等待队列较多，就很容易超时。
 * List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
 * 运行结果：5个返回("a" + u), 另5个抛出了CancellationException。 因为mmPool中最多支持5个线程，在跑下一批时已经超时。
 */
public class ThreadPoolExecutor_InvokeAllTest {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int u = i;
            list.add(() -> {
                System.out.println(Thread.currentThread());
                TimeUnit.SECONDS.sleep(1L);
                return ("a" + u);
            });
        }

        List<Future<String>> futures = mmPool.submit(list, 2L, TimeUnit.SECONDS);
        futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("InterruptedException");
            } catch (ExecutionException e) {
                e.printStackTrace();
                System.out.println("ExecutionException");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("exception");
            }
            return "";
        }).forEach(System.out::println);
//        TimeUnit.SECONDS.sleep(1L);
        //mmPool.shutdown();
    }

}
