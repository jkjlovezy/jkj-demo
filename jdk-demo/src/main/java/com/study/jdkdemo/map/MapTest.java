package com.study.jdkdemo.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        testAdd1();
        testAdd2();
        testAdd3();
    }

    private static void add1(Map<String, Set<String>> map, String key, String value) {
        if (map.get(key) == null) {
            map.put(key, new HashSet<>());
        }
        map.get(key).add(value);
    }

    private static void add2(Map<String, Set<String>> map, String key, String value) {
        map.compute(key, (k, v) -> {
            if (v == null) {
                Set<String> sets = new HashSet<>();
                sets.add(value);
                return sets;
            } else {
                v.add(value);
                return v;
            }
        });
    }

    private static void add3(Map<String, Set<String>> map, String key, String value) {
        map.computeIfAbsent(key, s -> new HashSet<>()).add(value);
    }

    private static void testAdd1() {
        Map<String, Set<String>> map = new HashMap<>();
        add1(map, "a", "a1");
        add1(map, "a", "a2");
        add1(map, "a", "a2");
        add1(map, "b", "b1");
        System.out.println(map);
    }

    private static void testAdd2() {
        Map<String, Set<String>> map = new HashMap<>();
        add2(map, "a", "a1");
        add2(map, "a", "a2");
        add2(map, "a", "a2");
        add2(map, "b", "b1");
        System.out.println(map);
    }


    private static void testAdd3() {
        Map<String, Set<String>> map = new HashMap<>();
        add3(map, "a", "a1");
        add3(map, "a", "a2");
        add3(map, "a", "a2");
        add3(map, "b", "b1");
        System.out.println(map);
    }


}
