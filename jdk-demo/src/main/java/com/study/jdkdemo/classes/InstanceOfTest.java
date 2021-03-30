package com.study.jdkdemo.classes;

import java.util.ArrayList;
import java.util.List;

public class InstanceOfTest {
    public static void main(String[] args) {
        Object o = new ArrayList<Integer>();
        System.out.println(o.getClass()==java.util.ArrayList.class);
        System.out.println(o.getClass()==java.util.List.class);
        System.out.println(o instanceof List);
    }


}
