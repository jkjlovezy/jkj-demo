package com.study.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ValidateController {

    @Autowired
    UserService userService;

    @Autowired
    IUserService userServiceImpl;

    @PostMapping("/user/add")
    public ApiResult<User> addUser(@RequestBody User user,String timeZone) {
        userService.addUser(user);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        System.out.println(timeZone+":\t"+sdf.format(user.getBirthday()));
        return ApiResult.success(user);
    }

    @PostMapping("/user/add2")
    public ApiResult<Void> addUser2(@RequestBody User user) {
        userService.addUser2(user.getUserId(), user.getUserName());
        return ApiResult.success();
    }

    @PostMapping("/user/add3")
    public ApiResult<Void> addUser3(@RequestBody User user) {
        userServiceImpl.addUser(user.getUserId(), user.getUserName());
        return ApiResult.success();
    }

    @PostMapping("/user/add4")
    public ApiResult<Void> addUser4(@RequestBody User user) {
        userServiceImpl.addUser2(user);
        return ApiResult.success();
    }
}
