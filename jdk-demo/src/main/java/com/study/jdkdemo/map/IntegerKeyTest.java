package com.study.jdkdemo.map;

import java.util.HashMap;
import java.util.Map;

public class IntegerKeyTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        Integer i = new Integer("200");
        map.put(i,"a");
        System.out.println(map.get(new Integer("200")));
    }
}
