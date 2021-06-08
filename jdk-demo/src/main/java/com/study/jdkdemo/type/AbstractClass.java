package com.study.jdkdemo.type;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractClass<S extends Request, R extends Response> {
    public R execute(S s) {
        R r = createResp();
        fillInfo(s, r);
        return r;
    }

    private R createResp() {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<R> respClass = (Class<R>) (parameterizedType.getActualTypeArguments()[1]);
            return respClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error");
        }
    }

    protected abstract void fillInfo(S s, R response);
}
