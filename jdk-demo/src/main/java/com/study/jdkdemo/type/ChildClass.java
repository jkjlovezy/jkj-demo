package com.study.jdkdemo.type;

public class ChildClass extends AbstractClass<OrderRequest, OrderResponse> {
    @Override
    protected void fillInfo(OrderRequest orderRequest, OrderResponse response) {
        response.setCode("000000");
        response.setMsg("Operate Success.");
    }
}
