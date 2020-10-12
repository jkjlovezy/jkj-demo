package com.study.provider1.service;

import org.springframework.stereotype.Service;

import com.focus.candy.support.spring.annotation.Consumer;
import com.study.sw.api.provider.UserProvider;

@Service
public class UserService {

    @Consumer(org = "silk", app = "sw_test_provider2")
    private UserProvider userProvider;

    public String getUser(Integer id) {
        return userProvider.getUser(id);
    }
}
