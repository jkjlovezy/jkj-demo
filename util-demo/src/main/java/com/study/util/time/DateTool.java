package com.study.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateTool {
    public static void main(String[] args) {
        System.out.println(DateToCnStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateToEnStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
    public static String DateToCnStr(Date date, String format) {
        String dateStr = "";
        try {
            if (StringUtils.isNotEmpty(format)) {
                dateStr = new SimpleDateFormat(format, Locale.CHINA).format(date);
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        return dateStr;
    }

    /**
     * 把日期转换成指定格式的字符串（英文）
     *
     * @param date
     * @param format
     * @return
     */
    public static String DateToEnStr(Date date, String format) {
        String dateStr = "";
        try {
            if (StringUtils.isNotEmpty(format)) {
                dateStr = new SimpleDateFormat(format, Locale.ENGLISH).format(date);
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        return dateStr;
    }
}
