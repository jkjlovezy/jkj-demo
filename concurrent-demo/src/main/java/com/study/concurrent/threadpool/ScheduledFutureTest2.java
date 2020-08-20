package com.study.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

/**
 * ExecutorService.shutdown()  VS ExecutorService.shutdownNow()
 * shutdown() 方法在终止前允许执行以前提交的任务。
 * shutdownNow() 方法阻止等待任务启动并试图停止当前正在执行的任务。
 * <p>
 * <p>
 * 若Runnable中，while循环中有Thread.sleep():
 * --1.sleep进行catch没有上抛异常：
 * ----ScheduledFuture.cancel() 与 ExecutorService.shutdownNow() 都不能终止该Runnable线程。
 * --2.sleep的异常catch后转化为RuntimeException，进行上抛：
 * ----ScheduledFuture.cancel() 与 ExecutorService.shutdownNow() 可以终止该Runnable线程。ExecutorService.shutdown()不能终止该Runnable线程。
 */
public class ScheduledFutureTest2 {

    public static void main(String[] args) {
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
//                runnable -> new Thread(runnable, "thread_prefix")
//        );
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5,
                runnable -> new Thread(runnable, "thread_prefix")
        );
        ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                new RunnableWithExceptionProtection(
                        () -> {
                            int i=0;
//                            while (true) {
//                                ThreadUtil.sleep(1000L);
////                                if(i++%10000==0)
//                                System.out.println(Thread.currentThread().getId() + "-run-" + DateTime.now().toString("HH:mm:ss"));
//                            }

                                ThreadUtil.sleep(1000L);
//                                if(i++%10000==0)
                                System.out.println(Thread.currentThread().getId() + "-run-" + DateTime.now().toString("HH:mm:ss"));
                        },
                        t -> System.out.println("log unexpected exception." + t)
                ), 0, 2,
                TimeUnit.SECONDS
        );

        /*ThreadUtil.sleep(10000L);*/
        /*System.out.println("-shutdown-" + DateTime.now().toString("HH:mm:ss"));*/
        /*scheduledExecutorService.shutdown();*/

        /*scheduledExecutorService.shutdownNow();*/

        ThreadUtil.sleep(2000L);
        System.out.println("-cancel-" + DateTime.now().toString("HH:mm:ss"));
        System.out.println("\n\n\n\n\n");
//        scheduledFuture.cancel(true);
        ThreadUtil.sleep(10000L);
        System.out.println("-over-" + DateTime.now().toString("HH:mm:ss"));
    }

    public static class ThreadUtil {
        public static void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (Exception e) {
//                throw new RuntimeException("interrupt exception");
            }
        }

    }
}




