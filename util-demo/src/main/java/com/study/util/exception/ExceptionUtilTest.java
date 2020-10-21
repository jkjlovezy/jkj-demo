package com.study.util.exception;

public class ExceptionUtilTest {
    public static void main(String[] args) {
        String s = ExceptionUtil.getSackTraceAsString(new IllegalStateException("custom exception:illegal state"));
        System.out.println(s);
    }
}
