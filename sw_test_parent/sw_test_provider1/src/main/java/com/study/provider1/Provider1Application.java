package com.study.provider1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.provider1.dao.mybatis")
public class Provider1Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider1Application.class, args);
    }
}
