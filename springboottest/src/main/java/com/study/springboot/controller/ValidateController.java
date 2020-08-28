package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.base.ApiResult;
import com.study.springboot.domain.User;
import com.study.springboot.service.UserService;

@RestController
public class ValidateController {

    @Autowired
    UserService userService;

    @PostMapping("/user/add")
    public ApiResult<Void> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ApiResult.success();
    }
}
