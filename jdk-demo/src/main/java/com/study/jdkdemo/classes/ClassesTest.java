package com.study.jdkdemo.classes;

public class ClassesTest {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2= o;
        System.out.println(o == o2);
        o = null;
        System.out.println(o);
        System.out.println(o2);
        System.out.println(o == o2);
    }
}
