package com.study.jdkdemo.string;

public class StringTest {
    public static void main(String[] args) {
        matches();
    }

    private static void matches() {
        System.out.println("/common/aa".matches("^/common/aa.*$"));
    }
}
