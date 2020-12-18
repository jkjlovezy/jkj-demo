package com.study.util.time;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import com.study.util.time.TimeBucket.TimeBucketTuple;

@Slf4j
public class DateUtil {
    public static String format(long milli, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Date dayPrecision(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            return date;
        } catch (ParseException e) {
            log.error("DateUtil.dayPrecision error.", e);
            throw new BusinessException(String.format("日期格式yyyy-MM-dd，传参：%s有误", str));
        }
    }

    public static Date hourPrecision(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH").parse(str);
            return date;
        } catch (ParseException e) {
            log.error("DateUtil.hourPrecision error.", e);
            throw new BusinessException(String.format("日期格式yyyy-MM-dd HH，传参：%s有误", str));
        }
    }

    public static Date minutePrecision(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str);
            return date;
        } catch (ParseException e) {
            log.error("DateUtil.minutePrecision error.", e);
            throw new BusinessException(String.format("日期格式yyyy-MM-dd HH:mm，传参：%s有误", str));
        }
    }

    public static Date secondPrecision(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            return date;
        } catch (ParseException e) {
            log.error("DateUtil.minutePrecision error.", e);
            throw new BusinessException(String.format("日期格式yyyy-MM-dd HH:mm:ss，传参：%s有误", str));
        }
    }

    public static TimeBucketTuple<Long, Long> getSecondTimeBucketTuple(String beginTime, String endTime, int acrossDefault, int acrossLimit) {
        if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
            Date currentDate = new Date();
            Long beginSecond = TimeBucket.getTimeBucket((DateUtils.addSeconds(currentDate, -acrossDefault)).getTime(), TimeBucket.Downsampling.Second);
            Long endSecond = TimeBucket.getTimeBucket(currentDate.getTime(), TimeBucket.Downsampling.Second);
            return new TimeBucketTuple<>(beginSecond, endSecond);
        } else {
            Date beginSecondDate = DateUtil.secondPrecision(beginTime);
            Date endSecondDate = DateUtil.secondPrecision(endTime);
            Validation.asserts(DateUtils.addSeconds(beginSecondDate, acrossLimit).after(endSecondDate), "跨度不能超过" + (acrossLimit / 60) + "分钟");
            return new TimeBucketTuple<>(TimeBucket.getTimeBucket(beginSecondDate.getTime(), TimeBucket.Downsampling.Second), TimeBucket.getTimeBucket(endSecondDate.getTime(), TimeBucket.Downsampling.Second));
        }
    }

    public static TimeBucketTuple<Long, Long> getMinuteTimeBucketTuple(String beginTime, String endTime, int acrossDefault, int acrossLimit) {
        if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
            Date currentDate = new Date();
            Long beginMunite = TimeBucket.getTimeBucket((DateUtils.addMinutes(currentDate, -acrossDefault)).getTime(), TimeBucket.Downsampling.Minute);
            Long endMinute = TimeBucket.getTimeBucket(currentDate.getTime(), TimeBucket.Downsampling.Minute);
            return new TimeBucketTuple<>(beginMunite, endMinute);
        } else {
            Date beginMinuteDate = DateUtil.minutePrecision(beginTime);
            Date endMinuteDate = DateUtil.minutePrecision(endTime);
            Validation.asserts(DateUtils.addMinutes(beginMinuteDate, acrossLimit).after(endMinuteDate), "跨度不能超过" + acrossLimit + "分钟");
            return new TimeBucketTuple<>(TimeBucket.getTimeBucket(beginMinuteDate.getTime(), TimeBucket.Downsampling.Minute), TimeBucket.getTimeBucket(endMinuteDate.getTime(), TimeBucket.Downsampling.Minute));
        }
    }

    public static TimeBucketTuple<Long, Long> getHourTimeBucketTuple(String beginTime, String endTime, int acrossDefault, int acrossLimit) {
        if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
            Date currentDate = new Date();
            Long beginHour = TimeBucket.getTimeBucket((DateUtils.addHours(currentDate, -acrossDefault)).getTime(), TimeBucket.Downsampling.Hour);
            Long endHour = TimeBucket.getTimeBucket(currentDate.getTime(), TimeBucket.Downsampling.Hour);
            return new TimeBucketTuple<>(beginHour, endHour);
        } else {
            Date beginHourDate = DateUtil.hourPrecision(beginTime);
            Date endHourDate = DateUtil.hourPrecision(endTime);
            Validation.asserts(DateUtils.addHours(beginHourDate, acrossLimit).after(endHourDate), "跨度不能超过" + acrossLimit + "小时");
            return new TimeBucketTuple<>(TimeBucket.getTimeBucket(beginHourDate.getTime(), TimeBucket.Downsampling.Hour), TimeBucket.getTimeBucket(endHourDate.getTime(), TimeBucket.Downsampling.Hour));
        }
    }

    public static TimeBucketTuple<Long, Long> getDayTimeBucketTuple(String beginTime, String endTime, int acrossDefault, int acrossLimit) {
        if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
            Date currentDate = new Date();
            Long beginDay = TimeBucket.getTimeBucket((DateUtils.addDays(currentDate, -acrossDefault)).getTime(), TimeBucket.Downsampling.Day);
            Long endDay = TimeBucket.getTimeBucket(currentDate.getTime(), TimeBucket.Downsampling.Day);
            return new TimeBucketTuple<>(beginDay, endDay);
        } else {
            Date beginDayDate = DateUtil.dayPrecision(beginTime);
            Date endDayDate = DateUtil.dayPrecision(endTime);
            Validation.asserts(DateUtils.addHours(beginDayDate, acrossLimit).after(endDayDate), "跨度不能超过" + acrossLimit + "天");
            return new TimeBucketTuple<>(TimeBucket.getTimeBucket(beginDayDate.getTime(), TimeBucket.Downsampling.Day), TimeBucket.getTimeBucket(endDayDate.getTime(), TimeBucket.Downsampling.Day));
        }
    }
}
