package com.study.util.time;

public class TimeSeriesUtilsTest {
    public static void main(String[] args) {
        System.out.println("20200101 belongs:\t" + TimeSeriesUtils.compressTimeBucket(20200101L, 15));
        System.out.println("20200113 belongs:\t" + TimeSeriesUtils.compressTimeBucket(20200113L, 15));
        System.out.println("20200114 belongs:\t" + TimeSeriesUtils.compressTimeBucket(20200114L, 15));
        System.out.println("20200115 belongs:\t" + TimeSeriesUtils.compressTimeBucket(20200115L, 15));
        System.out.println("20200116 belongs:\t" + TimeSeriesUtils.compressTimeBucket(20200116L, 15));
        System.out.println("20200122 belongs:\t" + TimeSeriesUtils.compressTimeBucket(20200122L, 15));
    }
}
