package com.study.util.time;

import static java.util.Locale.ENGLISH;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) {
//        for(String s: ZoneId.getAvailableZoneIds()){
//            System.out.println(s);
//        }
//        for(String s: TimeZone.getAvailableIDs()){
//            System.out.println(s);
//        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", ENGLISH);
        String s = null;
        sdf.setTimeZone(TimeZone.getTimeZone(s));
        System.out.println(sdf.format(new Date()));
        /*System.out.println("default TimeZone:" + TimeZone.getDefault());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println("Asia/Shanghai时区:" + sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("CTT"));
        System.out.println("CTT时区:" + sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println("GMT+8时区:" + sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println("PST时区:" + sdf.format(date));

        System.out.println(getDateStrAndTimeZone(date,"MMM dd, yyyy","PST"));*/
        /*Date d = new Date(1608100204909L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1608100210159L)));*/
    }



    public static String getDateStrAndTimeZone(Date date, String format, String timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return String.format("%s(%s)", sdf.format(date), timeZone);
    }
}
