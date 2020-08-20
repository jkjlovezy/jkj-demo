package com.study.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

public class ScheduledFutureTest {

    public static void main(String[] args) {
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
//                runnable -> new Thread(runnable, "thread_prefix")
//        );
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(20,
                runnable -> new Thread(runnable, "thread_prefix")
        );
        ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                new RunnableWithExceptionProtection(
                        () -> {
                            System.out.println(Thread.currentThread().getId()+"-run-" + DateTime.now().toString("HH:mm:ss"));
//                            while (true) {
//                                ThreadUtil.sleep(1000L);
//                                System.out.println("-run-" + DateTime.now().toString("HH:mm:ss"));
//                            }
                        },
                        t -> System.out.println("log unexpected exception." + t)
                ), 0, 2,
                TimeUnit.SECONDS
        );
        ThreadUtil.sleep(10000L);
        System.out.println("-shutdown-" + DateTime.now().toString("HH:mm:ss"));
        scheduledExecutorService.shutdown();
        ThreadUtil.sleep(10000L);
        System.out.println("-cancel-" + DateTime.now().toString("HH:mm:ss"));
        scheduledFuture.cancel(true);
        ThreadUtil.sleep(10000L);
        System.out.println("-over-" + DateTime.now().toString("HH:mm:ss"));
    }

    public static class ThreadUtil {
        public static void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (Exception e) {
                throw new RuntimeException("interrupt exception");
            }
        }
    }
}




