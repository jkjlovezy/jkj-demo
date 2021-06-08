package com.study.springboot.controller;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest extends BaseTest {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void getWithBody(){
        System.out.println(restTemplate);
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("appKey","20200929760537865812705280");
        httpHeaders.add("signType","rsa2");
        httpHeaders.add("timestamp","1621324477178");
        httpHeaders.add("sign","W7PfB60cZ8RvA5rzTUV8T0gtN3+NcwMD8ZRzhFxGzo983J6qvlsqDd1H4UpIlGrE92+TY2lP3GcqzzwvDDAdjxhKGN12WS9yNSQpnkshDqpKGcjP+MUVb9RGauSM1LQSIaOJGWu/ySxMKfPFwvD8PPtbRjFjyvhYKTslMbobhpiAeQQyQjMTaZbXHmyGw/vrBfTUPo7HUao82CW/QxSN0fEHYa769Gkgtmh1YYzPDV0d4SViCeLdrLtCaiJINcAlRvQU1tI9/e8RMFhkXmcT5wawDI6xN6TJmIdgLNccKsOftZ5JOI6eKUF74/RuTRMTpoOWLaVeLwCVp8SSfE2uSQ==");

        String body = "{\"ordBusiId\"：\"352104134879485331\"}";

        HttpEntity<String> requestEntity = new HttpEntity(body, httpHeaders);

        //ResponseEntity<String> response = restTemplate.exchange("https://openapi.doba.com/api/order/doba/queryOrder", HttpMethod.GET, requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.exchange("http://openapi.doba.com/api/order/doba/queryOrder", HttpMethod.GET, null, String.class);
        String result = response.getBody();
        System.out.println(result);
        System.out.println("--over--");
    }
}
