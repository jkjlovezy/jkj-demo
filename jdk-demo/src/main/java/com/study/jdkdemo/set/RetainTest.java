package com.study.jdkdemo.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RetainTest {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("a","b","c","d"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b","c","d","e"));
        //System.out.println(s1.retainAll(s2));
        System.out.println(s1.removeAll(s2));
        System.out.println(s1);
        System.out.println(s2);
    }
}
