package com.study.springboot.controller;

import org.springframework.util.AntPathMatcher;

public class AntPathMatcherTest {
    public static void main(String[] args) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        System.out.println(pathMatcher.match("*","crov_ss_sads"));
        System.out.println(pathMatcher.match("crov*","crov_ss_sads"));
        System.out.println(pathMatcher.match("crov_*","crov_ss_sads"));
        System.out.println(pathMatcher.match("crov_ss_sads","crov_ss_sads"));
    }
}
