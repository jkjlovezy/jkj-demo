package com.study.springboot.controller;

import org.springframework.util.AntPathMatcher;

public class AntPathMatcherTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            test2();
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
    }

    static void test() {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        System.out.println(pathMatcher.match("*", "crov_ss_sads"));
        System.out.println(pathMatcher.match("crov*", "crov_ss_sads"));
        System.out.println(pathMatcher.match("crov_*|ad_*", "crov_ss_s,ad_s"));
        System.out.println(pathMatcher.match("crov_ss_sads", "crov_ss_sads"));
    }

    static void test2() {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        pathMatcher.match("*", "crov_ss_sads");
        pathMatcher.match("crov*", "crov_ss_sads");
        pathMatcher.match("crov_*|ad_*", "crov_ss_s,ad_s");
        pathMatcher.match("crov_ss_sads", "crov_ss_sads");
    }
}
