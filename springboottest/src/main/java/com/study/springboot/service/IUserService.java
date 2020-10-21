package com.study.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.study.springboot.domain.User;
import com.study.springboot.enums.ParamValid;

public interface IUserService {

    void addUser(@NotNull Long userId,@NotNull String userName);

    void addUser2(Long userId,String userName);

    void addUser3(@Valid User user);

    void addUser4(User user);

    @ParamValid
    void addUser5(@Valid User user);
}
