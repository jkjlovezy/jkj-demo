package com.study.jdkdemo.enum_demo.chapter2;

public class Main {
    public static void main(String[] args) {
        TelemetryRelatedContext.INSTANCE.setId("testid");
        System.out.println(TelemetryRelatedContext.INSTANCE.getId());
    }
}
