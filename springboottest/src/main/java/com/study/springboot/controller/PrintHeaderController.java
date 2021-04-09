package com.study.springboot.controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintHeaderController {

    @GetMapping("/test/printuri")
    public String printURI(HttpServletRequest request){
        return request.getScheme()+"\n"+request.getRequestURL().toString()+"\n"+request.getRequestURI();
    }

    @RequestMapping(value = "/test/printuri2",method = RequestMethod.GET)
    public String printURI2(HttpServletRequest request){
        return request.getScheme()+"\n"+request.getRequestURL().toString()+"\n"+request.getRequestURI();
    }

    @GetMapping("/test/printheader")
    public String printHeader(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap != null) {
            paramMap.forEach((key, values) -> {
                System.out.printf("param\t%s : %s\n", key, Arrays.stream(values).reduce("", String::concat));
            });
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();

                System.out.printf("header\t%s : %s\n", headerName, request.getHeader(headerName));
            }
        }

        return "success";
    }

}
