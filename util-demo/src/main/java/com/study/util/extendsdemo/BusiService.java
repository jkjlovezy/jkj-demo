package com.study.util.extendsdemo;

import com.alibaba.fastjson.JSON;

public class BusiService {
    public void print(Parent parent){
        System.out.println(JSON.toJSONString(parent));
    }
}
