package com.study.springboot.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.study.springboot.TestApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@Slf4j
public class BaseTest {

    protected String tempOssLoginCookie = "YWRtaW46MTYxODA0NDg1NTg5NDoyNjdhZGRlOTAwZjQ5N2RjMjQ1MjhlNmYwYmU4NjkzOQ==";
    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected void get(String requestPath, MultiValueMap multiValueMap, Cookie... cookies) throws Exception {
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.get(requestPath);
        mock.contentType(MediaType.APPLICATION_FORM_URLENCODED).cookie(cookies).params(Optional.ofNullable(multiValueMap).orElse(new LinkedMultiValueMap()));
        String content = mockMvc.perform(mock).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn().getResponse()
                .getContentAsString();
        log.info("requestPath:{},response:{}", requestPath, content);
    }
}
