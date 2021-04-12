package com.study.springboot.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
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
@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BaseControllerTest {
    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;
    protected MockHttpServletRequest mockHttpServletRequest;
    protected MockHttpServletResponse mockHttpServletResponse;
    protected static AtomicBoolean isInit = new AtomicBoolean(false);

    @Before
    public void before() {
//        if (isInit.getAndSet(true) == false) {
        mockHttpServletRequest =
                new MockHttpServletRequest(webApplicationContext.getServletContext());
        mockHttpServletResponse = new MockHttpServletResponse();
        MockHttpSession mockHttpSession =
                new MockHttpSession(webApplicationContext.getServletContext());
        mockHttpServletRequest.setSession(mockHttpSession);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        }
    }

    protected void get(String requestPath, MultiValueMap multiValueMap) throws Exception {
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.get(requestPath);
        mock.contentType(MediaType.APPLICATION_FORM_URLENCODED).params(Optional.ofNullable(multiValueMap).orElse(new LinkedMultiValueMap()));
        String content = mockMvc.perform(mock).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn().getResponse()
                .getContentAsString();
        log.info("requestPath:{},response:{}", requestPath, content);
    }

    protected void post(String requestPath, String jsonContent) throws Exception {
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.post(requestPath);
        mock.contentType(MediaType.APPLICATION_JSON).content(jsonContent);
        String content = mockMvc.perform(mock).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn().getResponse()
                .getContentAsString();
        log.info("requestPath:{},response:{}", requestPath, content);
    }

    protected void delete(String requestPath, MultiValueMap multiValueMap) throws Exception {
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.delete(requestPath);
        mock.contentType(MediaType.APPLICATION_JSON).params(Optional.ofNullable(multiValueMap).orElse(new LinkedMultiValueMap()));
        String content = mockMvc.perform(mock).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn().getResponse()
                .getContentAsString();
        log.info("requestPath:{},response:{}", requestPath, content);
    }
}
