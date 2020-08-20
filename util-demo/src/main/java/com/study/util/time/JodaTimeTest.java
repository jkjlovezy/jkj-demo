package com.study.util.time;

import org.joda.time.DateTime;

public class JodaTimeTest {
    public static void main(String[] args) {
        DateTime nowTime = DateTime.now();
        System.out.println(nowTime);
        System.out.println(nowTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(nowTime.plus(-5000).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(nowTime.plusMillis(-5000).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(nowTime.plusSeconds(-5).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(nowTime.plusMinutes(-5).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTime.now().plusHours(-5).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTime.now().plusDays(-5).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTime.now().plusMonths(-5).toString("yyyy-MM-dd HH:mm:ss"));
    }
}
