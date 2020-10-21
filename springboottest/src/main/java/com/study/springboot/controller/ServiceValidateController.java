package com.study.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.base.ApiResult;
import com.study.springboot.domain.User;
import com.study.springboot.service.IUserService;
import com.study.springboot.service.UserService;

/**
 * 校验service的参数：
 * 1、需根据自定义注解做切面，根据@Valid注解做切面会报错。
 * 2、当serviceImpl时，参数的@Valid或@NotNull等注解需定义在interface的方法上 并且 自定义注解在serviceImpl的方法上。
 */
@RestController
public class ServiceValidateController {

    @Autowired
    UserService userService;

    @PostMapping("/validate/add")
    public ApiResult<User> addUser(@RequestBody User user,String timeZone) {
        userService.addUser(user);
        return ApiResult.success(user);
    }

    @PostMapping("/validate/add2")
    public ApiResult<Void> addUser2(@RequestBody User user) {
        userService.addUser2(user.getUserId(), user.getUserName());
        return ApiResult.success();
    }

    @PostMapping("/validate/add3")
    public ApiResult<Void> addUser3(@RequestBody User user) {
        userService.addUser3(user);
        return ApiResult.success();
    }

    @PostMapping("/validate/add4")
    public ApiResult<Void> addUser4(@RequestBody User user) {
        userService.addUser4(user);
        return ApiResult.success();
    }

}
