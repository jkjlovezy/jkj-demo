package com.study.springboot.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.base.ApiResult;
import com.study.springboot.domain.User;
import com.study.springboot.service.IUserService;
import com.study.springboot.service.UserService;

/**
 * 校验service的参数：
 * 1、需根据自定义注解@ParamValid做切面，根据@Valid注解做切面会报错。
 * 2、当serviceImpl时，参数的@Valid或@NotNull等注解需定义在interface的方法上 并且 用于切面的自定义注解@ParamValid在serviceImpl的方法上。
 */
@RestController
public class ServiceImplValidateController {

    @Autowired
    IUserService userServiceImpl;

    @PostMapping("/serviceimpl/validate/add")
    public ApiResult<Void> addUser(@RequestBody User user) {
        userServiceImpl.addUser(user.getUserId(), user.getUserName());
        return ApiResult.success();
    }

    @PostMapping("/serviceimpl/validate/add2")
    public ApiResult<Void> addUser2(@RequestBody User user) {
        userServiceImpl.addUser2(user.getUserId(), user.getUserName());
        return ApiResult.success();
    }

    @PostMapping("/serviceimpl/validate/add3")
    public ApiResult<Void> addUser3(@RequestBody User user) {
        userServiceImpl.addUser3(user);
        return ApiResult.success();
    }

    @PostMapping("/serviceimpl/validate/add4")
    public ApiResult<String> addUser4(@RequestBody User user) {
        userServiceImpl.addUser4(user);
        return ApiResult.success();
    }

    @PostMapping("/serviceimpl/validate/add5")
    public ApiResult<String> addUser5(@RequestBody User user) {
        userServiceImpl.addUser5(user);
        return ApiResult.success();
    }

}
