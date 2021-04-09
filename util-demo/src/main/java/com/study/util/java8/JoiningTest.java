package com.study.util.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        List<String> list2 = Arrays.asList("aaa");
        System.out.println(list.stream().collect(Collectors.joining(" -> ")));
        System.out.println(list2.stream().collect(Collectors.joining(" -> ")));
    }
}
