package com.study.util.java8;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndDistinctListTest {
    public static void main(String[] args) {

        List<Service> list = new ArrayList();
        list.add(new Service("1", "s1"));
        list.add(new Service("1", "s1"));
        list.add(new Service("2", "b"));
        list.add(new Service("3", "a"));
        list.add(new Service("3", "c"));
//        List<Service> resultList = Optional.ofNullable(list).orElse(Collections.emptyList()).stream().distinct().sorted(Comparator.comparing(Service::getName)).collect(Collectors.toList());
        List<Service> resultList = list.stream().distinct().sorted(Comparator.comparing(Service::getName)).collect(Collectors.toList());

        for (Service s : resultList) {
            System.out.println(s);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode(of = {"id"})
    public static class Service {
        private String id;
        private String name;
    }
}
