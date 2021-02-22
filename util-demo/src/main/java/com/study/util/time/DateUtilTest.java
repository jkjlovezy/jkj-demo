package com.study.util.time;

import java.time.Instant;

public class DateUtilTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(DateUtil.format(1600063859901L, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtil.format(1600063859901L, "yyyy-MM-dd'T'HH:mm:ss'Z'"));

        System.out.println(Instant.now());
        System.out.println(DateUtil.getSecondTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30 * 60, 60 * 60));
        System.out.println(DateUtil.getMinuteTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30, 60));
        System.out.println(DateUtil.getHourTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30, 60));
        System.out.println(DateUtil.getDayTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30, 60));
    }
}
