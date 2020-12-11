package com.study.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.swagger.annotation.CrovApi;
import com.study.swagger.annotation.DobaApi;
import com.study.swagger.annotation.MicApi;
import com.study.swagger.controller.request.UserGetRequest;
import com.study.swagger.controller.response.UserGetResponse;

@RestController
@RequestMapping("/sian")
//@Api(value = "/user", hidden = true)
public class UserController {

    @GetMapping("/user/get")
    @ApiOperation(value = "会员查询2",tags ={"卖家--会员","买家--会员"} )
    @CrovApi
    public UserGetResponse getUser(UserGetRequest request){
        return new UserGetResponse(1,"test",21);
    }

    @GetMapping("/user/noneAnnotation")
    @ApiOperation(value = "会员查询-无注解",tags ={"卖家--会员","买家--会员"} )
    public String noneAnnotation(UserGetRequest request){
        return "";
    }
}
