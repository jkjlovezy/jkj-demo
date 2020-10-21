package com.study.util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wangyajun
 * @since 17/9/22 14:48
 */
public abstract class ExceptionUtil {
    static final StackTraceElement[] NONE_STE = new StackTraceElement[0];

    /**
     * 是或者含有此类型异常
     *
     * @param exceptionType 目标类型
     * @param e             被检查的异常实例
     * @return 是true否false
     */
    public static boolean isOrContains(Class<? extends Throwable> exceptionType, Throwable e) {
        if (e == null || exceptionType == null) {
            return false;
        }

        if (exceptionType.isInstance(e)) {
            return true;
        } else {
            return isOrContains(exceptionType, e.getCause());
        }
    }

    /**
     * 在异常栈中提取目标异常
     *
     * @param exceptionType 目标类型
     * @param e             被检查的异常实例
     * @see #isOrContains(Class, Throwable)
     */
    public static Throwable extractException(Class<? extends Throwable> exceptionType, Throwable e) {
        if (e == null || exceptionType == null) {
            return null;
        }

        if (exceptionType.isInstance(e)) {
            return e;
        } else {
            return extractException(exceptionType, e.getCause());
        }
    }

    /**
     * 将异常堆栈存储以String保存
     *
     * @param throwable
     * @return 异常为null返回空字符串""
     */
    public static String getSackTraceAsString(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        pw.flush();
        return sw.getBuffer().toString();
    }


    /**
     * 清除异常堆栈信息
     *
     * @param ex
     * @return
     */
    public static <E extends Exception> E clearStackTraceThenReturn(E ex) {
        ex.setStackTrace(NONE_STE);
        return ex;
    }

    /**
     * 从反射异常中提取真实异常
     *
     * @param source
     * @return
     */
    public static Throwable extractRealExceptionFromReflect(Exception source) {
        if (source == null)
            return source;
        if (source instanceof InvocationTargetException) {
            return source.getCause();
        }
        return source;
    }
}
