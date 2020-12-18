package com.study.util.time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String[] args) {
//        for(String s: ZoneId.getAvailableZoneIds()){
//            System.out.println(s);
//        }
//        for(String s: TimeZone.getAvailableIDs()){
//            System.out.println(s);
//        }
        System.out.println("default TimeZone:"+TimeZone.getDefault().getID());
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("CTT"));
        System.out.println("CTT:"+sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println("GMT+8:"+sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println("PST:"+sdf.format(date));

        Date d = new Date(1608100204909L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1608100210159L)));
    }
}
