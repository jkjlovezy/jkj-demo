package com.study.util.time;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtilTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDateTime.now().format(ofPattern("yyyyMMdd_HHmmss")));

        System.out.println(DateUtil.secondPrecision("2021-04-19 00:00:00").getTime());
        System.out.println(DateUtil.secondPrecision("2021-04-19 23:59:59").getTime());
        System.out.println(DateUtil.secondPrecision("2021-05-19 23:59:59").getTime());
        System.out.println(DateUtil.secondPrecision("2022-04-19 23:59:59").getTime());
        System.out.println(LocalDate.now().format(ofPattern("yyyyMMdd")));
        System.out.println(DateUtil.convertDayPrecision("20210422", "yyyyMMdd", "yyyy年MM月dd日"));
        System.out.println(DateUtil.convertMonthPrecision("202104", "yyyyMM", "yyyy年MM月"));
        System.out.println(System.currentTimeMillis());
        System.out.println(DateUtil.format(1617759077691L, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtil.format(1600063859901L, "yyyy-MM-dd'T'HH:mm:ss'Z'"));

        System.out.println(Instant.now());
        System.out.println(DateUtil.getSecondTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30 * 60, 60 * 60));
        System.out.println(DateUtil.getMinuteTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30, 60));
        System.out.println(DateUtil.getHourTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30, 60));
        System.out.println(DateUtil.getDayTimeBucketTuple("2020-12-18 01:02:03", "2020-12-18 01:15:03", 30, 60));
    }
}
