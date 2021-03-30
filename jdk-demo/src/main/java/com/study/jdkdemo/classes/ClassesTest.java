package com.study.jdkdemo.classes;

public class ClassesTest {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2= o;
        o = null;
        System.out.println(o);
        System.out.println(o2);
    }
}
