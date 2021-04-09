package com.study.jdkdemo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampTest {
    public static void main(String[] args) {
        //当前时间戳
        long timestamp = System.currentTimeMillis();
        Date date = new Date(timestamp);
        System.out.println(timestamp + ",\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));


        //1617156208905，这个时间戳按照解析出的时间为2021-03-31 10:03:28， 而日志中的日志打印时间2021-04-01 09:29:10 所以1617156208905这个时间早就过期了。
        Date date2 = new Date(1617156208905L);
        System.out.println(1617156208905L + ",\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2));

        Date date3 = new Date(161733084379L);
        System.out.println(1617330843790L + ",\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date3));

        Date date4 = new Date(1617374102136L);

        System.out.println(1617374102136L + ",\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date4));

    }
}
