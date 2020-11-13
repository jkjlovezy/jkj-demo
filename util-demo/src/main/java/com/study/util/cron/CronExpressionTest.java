package com.study.util.cron;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;

public class CronExpressionTest {
    public static void main(String[] args) throws ParseException {
        CronExpression cronExpression = new CronExpression("0 0 0 1/1 * ? *");
        Date date = new Date();
        System.out.println(cronExpression.getNextValidTimeAfter(date));
        System.out.println(cronExpression.getNextInvalidTimeAfter(date));
    }
}
