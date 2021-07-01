package com.study.jdkdemo.math;

import static java.lang.Math.exp;

public class MathTest {
    private static final int INTERVAL = 5;
    private static final double SECONDS_PER_MINUTE = 60.0;
    private static final int ONE_MINUTE = 1;
    private static final int FIVE_MINUTES = 5;
    private static final int FIFTEEN_MINUTES = 15;

    private static final double M1_ALPHA = 1 - exp(-INTERVAL / SECONDS_PER_MINUTE / ONE_MINUTE);
    private static final double M5_ALPHA = 1 - exp(-INTERVAL / SECONDS_PER_MINUTE / FIVE_MINUTES);
    private static final double M15_ALPHA = 1 - exp(-INTERVAL / SECONDS_PER_MINUTE / FIFTEEN_MINUTES);

    public static void main(String[] args) {
        System.out.println(M1_ALPHA);
        System.out.println(M5_ALPHA);
        System.out.println(M15_ALPHA);
        System.out.println(exp(4));
    }
}
