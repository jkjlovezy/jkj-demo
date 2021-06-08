package com.study.util.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "time=2019-01-01 00:00:00";
        String es = URLEncoder.encode(s,"utf-8");
        System.out.println(es);
        String ds = URLDecoder.decode(es,"utf-8");
        System.out.println(ds);

        System.out.println(URLEncoder.encode("Lh Basic & Home Inc. Qingdao Bright Building Materials Co.,Ltd. !@#$%^&*()-={}|:\"<>?,./;'[]\\ ;; \"Gg\" 'test'","utf-8"));
    }
}

