package com.study.jdkdemo.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Set<String>> map = new HashMap<>();
        add(map, "a", "a1");
        add(map, "a", "a2");
        add(map, "a", "a2");
        add(map, "b", "b1");
        System.out.println(map);
    }

    private static void add(Map<String, Set<String>> map, String key, String value) {
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
}
