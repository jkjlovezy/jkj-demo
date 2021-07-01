package com.study.jdkdemo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    static final Pattern importPattern = Pattern.compile("import\\s+([\\w\\.\\*]+);\n");
    static final Pattern testPattern = Pattern.compile("import\\s+([a-z]+)([A-Z]+)([1-9]*);");

    public static void main(String[] args) {
        importPattern();
        //testPattern();
    }

    /**
     * group0与group1之间的空行是group0中的字符\n,。
     * start = 0
     * end = 28
     * group0 = import java.io.InputStream;
     *
     * group1 = java.io.InputStream
     * -----------------
     * start = 28
     * end = 57
     * group0 = import java.io.OutputStream;
     *
     * group1 = java.io.OutputStream
     * -----------------
     */
    static void importPattern() {
        Matcher matcher = importPattern.matcher("import java.io.InputStream;\nimport java.io.OutputStream;\n");
        while (matcher.find()) {
            System.out.println("start = " + matcher.start());
            System.out.println("end = " + matcher.end());
            System.out.println("group0 = " + matcher.group(0));
            System.out.println("group1 = " + matcher.group(1));
            System.out.println("-----------------");
        }
    }

    /**
     * start = 0
     * end = 14
     * group0 = import aaaAAA;
     * group1 = aaa
     * group2 = AAA
     * group3 =
     *
     * start = 14
     * end = 31
     * group0 = import abcABC123;
     * group1 = abc
     * group2 = ABC
     * group3 = 123
     */
    static void testPattern() {
        Matcher matcher = testPattern.matcher("import aaaAAA;import abcABC123;");
        while (matcher.find()) {
            System.out.println("start = " + matcher.start());
            System.out.println("end = " + matcher.end());
            System.out.println("group0 = " + matcher.group(0));
            System.out.println("group1 = " + matcher.group(1));
            System.out.println("group2 = " + matcher.group(2));
            System.out.println("group3 = " + matcher.group(3));
            System.out.println("-----------------");
        }
    }
}
