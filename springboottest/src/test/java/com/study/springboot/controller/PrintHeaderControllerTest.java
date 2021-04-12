package com.study.springboot.controller;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;

public class PrintHeaderControllerTest extends BaseTest {

    @Test
    public void printURI() throws Exception {
        get("/test/printuri", new LinkedMultiValueMap<String, String>() {
            {
                add("siteType", "1");
            }
        }, new Cookie("focus_oss2008", tempOssLoginCookie));
    }
}
