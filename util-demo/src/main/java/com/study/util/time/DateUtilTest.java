package com.study.util.time;

import java.time.Instant;
import java.util.Date;

public class DateUtilTest {
    public static void main(String[] args) {
        System.out.println(DateUtil.format(1600063859901L,"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtil.format(1600063859901L,"yyyy-MM-dd'T'HH:mm:ss'Z'"));

        System.out.println(Instant.now());
    }
}
