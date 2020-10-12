package com.study.springboot.controller;

import java.text.SimpleDateFormat;
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
        /*System.out.println("default TimeZone:"+TimeZone.getDefault().getID());
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("CTT"));
        System.out.println("CTT:"+sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println("GMT+8:"+sdf.format(date));
        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println("PST:"+sdf.format(date));*/

        String[] splitNameArray = "gateway$$open.com:8888$$/a/getUser2".split("\\$\\$");
        for(String s: splitNameArray){
            System.out.println(s);
        }
    }
}
