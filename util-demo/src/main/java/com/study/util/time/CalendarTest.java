package com.study.util.time;

import java.time.Duration;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        long year = calendar.get(Calendar.YEAR);
        long month = calendar.get(Calendar.MONTH) + 1;
        long day = calendar.get(Calendar.DAY_OF_MONTH);
        long hour = calendar.get(Calendar.HOUR_OF_DAY);
        long minute = calendar.get(Calendar.MINUTE);
        long second = calendar.get(Calendar.SECOND);

        System.out.println(year * 10000000000L + month * 100000000 + day * 1000000 + hour * 10000 + minute * 100 + second);
        System.out.println(year * 100000000 + month * 1000000 + day * 10000 + hour * 100 + minute);
        System.out.println(year * 1000000 + month * 10000 + day * 100 + hour);
        System.out.println(year * 10000 + month * 100 + day);
        System.out.println(year * 100 + month);
        Thread.sleep(Duration.ofMinutes(5).toMillis());
    }
}
