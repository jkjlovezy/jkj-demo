package com.study.util.time;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class TimeBucketTest {
    public static void main(String[] args) {

        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),TimeBucket.Downsampling.Minute));
        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),TimeBucket.Downsampling.Hour));
        System.out.println(TimeBucket.getTimeBucket(new Date().getTime(),TimeBucket.Downsampling.Day));
        System.out.println("---------------------");
        System.out.println(TimeBucket.getTimeBucket((DateUtils.addDays(new Date(),-6)).getTime(),TimeBucket.Downsampling.Day));
        System.out.println(TimeBucket.getTimeBucket((DateUtils.addHours(new Date(),-23)).getTime(),TimeBucket.Downsampling.Hour));
        System.out.println(TimeBucket.getTimeBucket((DateUtils.addMinutes(new Date(),-59)).getTime(),TimeBucket.Downsampling.Minute));
    }
}
