package com.study.network;

import java.net.URI;

import com.alibaba.fastjson.JSON;

public class URITest {
    public static void main(String[] args) {
        URI uri = URI.create("https://www.com/ad?a=1");
        System.out.println(JSON.toJSONString(uri));
        System.out.println(uri.getRawPath());
        System.out.println(uri.getPath());
    }
}
