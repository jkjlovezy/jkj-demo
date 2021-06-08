package com.study.jdkdemo.map;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConcurrentMapTest instance = new ConcurrentMapTest();
        Callable call = () -> instance.getAdminClient("a");
        FutureTask task1 = new FutureTask<>(call);
        FutureTask task2 = new FutureTask<>(call);
        new Thread(task1).start();
        new Thread(task2).start();
        System.out.println("task1.get:" + task1.get());
        System.out.println("task2.get:" + task2.get());
        System.out.println(task1.get() == task2.get());
    }

    private Map<String, AdminClient> adminClientMap = new ConcurrentHashMap<>();

    public AdminClient getAdminClient(String brokerId) {
        AdminClient client = adminClientMap.get(brokerId);
        if (client == null) {
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client = new AdminClient(brokerId);
            System.out.println(Thread.currentThread().getId() + ",newClient:" + client);
            AdminClient oldClient = adminClientMap.putIfAbsent(brokerId, client);    //此处可能2个线程都走进来，第2个线程就不会再放进map中，并且第2个线程此时返回旧值，即第1个线程创建的client。
            System.out.println(Thread.currentThread().getId() + ",oldClient:" + oldClient);
            if (oldClient != null) {
                client = oldClient;
            }
        }
        return client;
    }

    static class AdminClient {
        private String name;

        public AdminClient(String name) {
            this.name = name;
        }
    }
}
