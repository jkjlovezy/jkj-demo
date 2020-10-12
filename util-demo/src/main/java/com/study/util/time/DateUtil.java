package com.study.util.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String format(long milli, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
