package com.study.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.study.springboot.domain.User;
import com.study.springboot.enums.ValidPt;

public interface IUserService {

    void addUser(@NotNull Long userId,@NotNull String userName);

    void addUser2(@Valid User user);
}
