package com.study.util.time;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class TimeBucketTest {
    public static void main(String[] args) {

        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),DownSampling.Minute));
        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),DownSampling.Hour));
        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),DownSampling.Day));
        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),DownSampling.Month));
        System.out.println("---------------------");
        System.out.println(TimeBucket.getTimeBucket((DateUtils.addDays(new Date(),-6)).getTime(),DownSampling.Day));
        System.out.println(TimeBucket.getTimeBucket((DateUtils.addHours(new Date(),-23)).getTime(),DownSampling.Hour));
        System.out.println(TimeBucket.getTimeBucket((DateUtils.addMinutes(new Date(),-59)).getTime(),DownSampling.Minute));

        System.out.println(TimeBucket.getTimeBucket(System.currentTimeMillis(), DownSampling.Day)/1000000);
    }
}
