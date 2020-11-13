package com.study.provider1.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.provider1.service.UserService;
import com.study.sw.api.domain.CustomException;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/a/getUser")
    public String getUser(Integer userId) {
        sleep(userId);
        log.info("UserController.getUser: {}", userId);
        try {
            return userService.getUser(userId);
        }catch (CustomException e){
            log.info("provider service customException. {}",e.getMessage());
            return null;
        }catch (Exception e){
            log.info("provider service exception. {}",e.getMessage());
            return null;
        }
    }

    @GetMapping("/a/getUser2")
    public String getUser2(Integer userId) {
        sleep(userId);
        log.info("UserController.getUser2: {}", userId);
        return "getUser2_" + userId;
    }

    private void sleep(long mill) {
        try {
            Thread.sleep(mill);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
