package com.study.jdkdemo.ewma;

import java.util.concurrent.TimeUnit;

public class EWMATest {
    public static void main(String[] args) throws InterruptedException {
        EWMA oneMinute = EWMA.oneMinuteEWMA();
        EWMA fiveMinute = EWMA.fiveMinuteEWMA();
        for (int i = 0; i < 60; i++) {
            oneMinute.update(100);
            oneMinute.update(100);
            oneMinute.update(100);
            fiveMinute.update(100);
            fiveMinute.update(100);
            fiveMinute.update(100);
            Thread.sleep(500L);
            if (i != 3 && i != 4 && i != 5) {
                oneMinute.tick();
                fiveMinute.tick();
            }
        }
        System.out.println(oneMinute.rate(TimeUnit.SECONDS));
    }
}
