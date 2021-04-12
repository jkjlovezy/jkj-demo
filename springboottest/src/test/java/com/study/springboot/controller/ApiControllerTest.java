package com.study.springboot.controller;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;

import com.alibaba.fastjson.JSON;
import com.study.springboot.domain.User;

public class ApiControllerTest extends BaseControllerTest {
    @Test
    public void testPost() throws Exception {
        post("/serviceimpl/validate/add", JSON.toJSONString(new User()));
    }

    @Test
    public void testDelete() throws Exception {
        delete("/api/delete", new LinkedMultiValueMap<String, String>() {
            {
                add("id", "1");
            }
        });
    }


    @Test
    public void testGet() throws Exception {
        get("/api/get", new LinkedMultiValueMap<String, String>() {
            {
                add("id", "1");
            }
        });
    }

}
