package com.study.jdkdemo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutIndexTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list.subList(0,Math.min(10,list.size())));

        List<Integer> list2 = Arrays.asList(1,2,3);
        System.out.println(list.subList(2,2));
    }
}
