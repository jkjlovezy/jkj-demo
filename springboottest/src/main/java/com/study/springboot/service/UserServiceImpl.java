package com.study.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.study.springboot.domain.User;
import com.study.springboot.enums.ValidPt;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    @ValidPt
    public void addUser(@NotNull Long userId, @NotNull String userName) {
        System.out.println("UserServiceImpl.addUser:" + userId + userName);
    }

    @Override
    @ValidPt
    public void addUser2(User user){
        System.out.println("UserServiceImpl.addUser2:" + user.getUserId() + user.getUserName());
    }
}
