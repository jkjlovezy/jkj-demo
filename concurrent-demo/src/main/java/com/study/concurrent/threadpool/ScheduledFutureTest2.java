package com.study.concurrent.threadpool;

import java.lang.management.ManagementFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

/**
 * ExecutorService.shutdown()  VS ExecutorService.shutdownNow()
 * shutdown() 方法在终止前允许执行以前提交的任务。
 * shutdownNow() 尝试停止所有正在执行的任务，停止等待任务的处理，并返回等待执行的任务列表。
 * <p>
 * <p>
 * 若Runnable中，while循环中有Thread.sleep(),注意是while循环中有sleep:
 * --1.sleep进行catch没有上抛异常：
 * ----ScheduledFuture.cancel(true) 与 ExecutorService.shutdownNow() 都不能终止该Runnable线程。 原因是线程没有执行结束，继续while循环
 * --2.sleep上抛异常，退出while循环：
 * ----ScheduledFuture.cancel(true) 与 ExecutorService.shutdownNow() 可以终止该Runnable线程。ScheduledFuture.cancel(false)与ExecutorService.shutdown()不能终止该Runnable线程。
 */
public class ScheduledFutureTest2 {

    public static void main(String[] args) {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
//                runnable -> new Thread(runnable, "thread_prefix")
//        );
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5,
                runnable -> new Thread(runnable, "thread_prefix")
        );
        ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                new RunnableWithExceptionProtection(
                        () -> {
                            while (true) {
                                mockRemoteCall(1000L);
                                System.out.println(Thread.currentThread().getId() + "-run-" + DateTime.now().toString("HH:mm:ss"));
                            }
                        },
                        t -> System.out.println("log unexpected exception." + t)
                        /*t -> {
                            throw new RuntimeException(t);
                        }*/
                ), 0, 10,
                TimeUnit.SECONDS
        );
        delayCall(5L, () -> scheduledFuture.cancel(true));
        //delayCall(5L, () -> scheduledFuture.cancel(false));
         delayCall(5L, () -> scheduledExecutorService.shutdownNow());
        //delayCall(5L, () -> scheduledExecutorService.shutdown());
    }

    static void delayCall(Long seconds, Runnable runnable) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            System.out.println("-delayCall-" + DateTime.now().toString("HH:mm:ss"));
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void mockRemoteCall(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("interrupt exception");
        }
    }


}




