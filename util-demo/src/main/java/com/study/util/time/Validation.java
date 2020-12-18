package com.study.util.time;

import java.util.List;

public class Validation {

    private Validation() {
    }

    public static void check(Object obj, String name) {
        check(obj != null, name);
    }

    public static void check(boolean exp, String name) {
        asserts(exp, "%s参数错误", name);
    }

    public static void error(String message) {
        throw new BusinessException(message);
    }

    public static void assertNotNull(Object o, String errorMessage, Object... args) {
        if (o == null)
            throwBusinessException(errorMessage, args);
    }

    public static void assertNull(Object o, String errorMessage, Object... args) {
        if (o != null)
            throwBusinessException(errorMessage, args);
    }

    public static <T> void assertNotEmpty(List<T> o, String errorMessage, Object... args) {
        if (o == null || o.isEmpty())
            throwBusinessException(errorMessage, args);
    }

    public static <T> void assertEmpty(List<T> o, String errorMessage, Object... args) {
        if (o != null && !o.isEmpty())
            throwBusinessException(errorMessage, args);
    }


    public static void asserts(boolean b, String errorMessage, Object... args) {
        if (!b)
            throwBusinessException(errorMessage, args);
    }

    public static void throwBusinessException(String errorMessage, Object... args) {
        throw new BusinessException(String.format(errorMessage, args));
    }

}
