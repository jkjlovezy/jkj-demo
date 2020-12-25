package com.study.util.spring;

import org.springframework.web.util.HtmlUtils;

public class HtmlUtilsTest {
    public static void main(String[] args) {
        System.out.println(HtmlUtils.htmlEscape("<html>a !@#$%^&*() /?{}|a</i>"));
        System.out.println(HtmlUtils.htmlEscape("<i>aa</i>"));
        System.out.println(HtmlUtils.htmlEscape("<<i>>aa</i>"));
    }
}
