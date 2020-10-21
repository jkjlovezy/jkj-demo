package com.study.scala;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;

    private final Iterable<String> batches;

    public User(String name) {
        this.name = name;
        this.batches = initBatches();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterable<String> getBatches() {
        return batches;
    }

    private Iterable<String> initBatches() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return list;
    }
}
