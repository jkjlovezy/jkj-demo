package com.study.provider2.service;

import lombok.extern.slf4j.Slf4j;

import com.focus.candy.support.spring.annotation.Provider;
import com.study.sw.api.domain.CustomException;
import com.study.sw.api.provider.UserProvider;

@Provider(serviceInterfaces = UserProvider.class)
@Slf4j
public class UserProviderImpl implements UserProvider {
    public String getUser(Integer id) {

        sleep(id + 30);
        log.info("UserProviderImpl.getUser: {}", id);
        //throw new CustomException("你的传参有误");
        return "userId_" + id;
    }

    private void sleep(long mill) {
        try {
            Thread.sleep(mill);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
