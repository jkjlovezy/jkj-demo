package com.study.util.java8;

import java.util.Comparator;
import java.util.stream.Stream;

public class MinTest
{
    public static void main(String[] args) {
        System.out.println(Stream.of(4,2,3).min(Comparator.comparingInt(i->i)).get());
    }
}
