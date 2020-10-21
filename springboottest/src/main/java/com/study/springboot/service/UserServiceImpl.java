package com.study.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.study.springboot.domain.User;
import com.study.springboot.enums.ParamValid;

@Service
public class UserServiceImpl implements IUserService {

    //进行校验
    @Override
    @ParamValid
    public void addUser(Long userId, String userName) {
        System.out.println("UserServiceImpl.addUser:" + userId + userName);
    }

    //校验时报错：大体意思是overriding方法，不能 redefine the parameter constraint configuration。
    @Override
    @ParamValid
    public void addUser2(@NotNull Long userId, @NotNull String userName) {
        System.out.println("UserServiceImpl.addUser:" + userId + userName);
    }

    //进行校验
    @Override
    @ParamValid
    public void addUser3(User user) {
        System.out.println("UserServiceImpl.addUser2:" + user.getUserId() + user.getUserName());
    }

    //校验时报错：大体意思是overriding方法，不能 redefine the parameter constraint configuration.
    @Override
    @ParamValid
    public void addUser4(@Valid User user) {
        System.out.println("UserServiceImpl.addUser3:" + user.getUserId() + user.getUserName());
    }

    //不进行校验，原因@ParamValid应加在实现方法，而不是接口的方法上。
    @Override
    public void addUser5(User user) {
        System.out.println("UserServiceImpl.addUser3:" + user.getUserId() + user.getUserName());
    }
}
