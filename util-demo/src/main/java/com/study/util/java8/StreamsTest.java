package com.study.util.java8;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> filteredList = Streams.filter(list, s -> s.equals("a"));
        System.out.println("filteredList: " + filteredList.stream().collect(joining(",")));

        List<String> filteredList2 = Streams.filterAll(list, s -> s.equals("a"), s -> s.equals("c"));
        System.out.println("filteredList2: " + filteredList2.stream().collect(joining(",")));

        List<String> filteredList3 = Streams.filterAny(list, s -> s.equals("a"), s -> s.equals("c"));
        System.out.println("filteredList3: " + filteredList3.stream().collect(joining(",")));
    }
}
