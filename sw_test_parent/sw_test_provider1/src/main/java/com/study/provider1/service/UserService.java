package com.study.provider1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus.candy.support.spring.annotation.Consumer;
import com.study.provider1.dao.mybatis.MybatisUserDao;
import com.study.sw.api.provider.UserProvider;

@Service
public class UserService {

    @Consumer(org = "silk", app = "sw_test_provider2")
    private UserProvider userProvider;
    @Autowired
    MybatisUserDao userDao;

    public String getUser(Integer id) {
        System.out.println(userDao.countAccPf());
        return userProvider.getUser(id);
    }
}
