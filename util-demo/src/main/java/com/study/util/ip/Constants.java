/*
 * Copyright 2013 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.study.util.ip;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Constants.java
 * 
 * @author chengzhaoyu
 */
public class Constants {

    public static final String SEP_COMBINE_KEY = "_";
    public static final String SEP_SEMICOLON = ";";
    public static final String SEP_COMMA = ",";
    public static final String SEP_POINT = ".";
    public static final String SEP_LINE = "-";
    public static final String SEP_SPACE = " ";
    public static final String SEP_EMPTY = "";
    public static final String SEP_COOKIE_SUFFIX = "~!,";
    public static final String SEP_COOKIE_PREFIX = "_~";
    public static final String SEP_VERTICAL = "|";
    public static final String SEP_COLON = ":";
    public static final String SEP_TABS = "\t";
    public static final String SEP_SLASH_POINT = "\\.";
    public static final String SEP_SLASH = "/";
    public static final String SEP_QUESTION_MARK = "?";
    public static final String SEP_EQUAL_MARK = "=";

    public static final String LINE_FEED_WINDOWS = "\r\n";
    public static final String LINE_FEED_UNIX = "\n";

    public static final String SEP_STAR = "*";

    /**
     * 编码格式
     */
    public static final String CODING_FORMAT_UTF_8 = "UTF-8";

    /**
     * 英文
     */
    public static final String SILK_LANGUAGE01_EN = "0";

    /**
     * 中文
     */
    public static final String SILK_LANGUAGE01_CN = "1";

    /**
     * 中英文
     */
    public static final String SILK_LANGUAGE01_CN_AND_EN = "2";

    /**
     * 北京时区
     */
    public static final String BJ_TIME_ZONE = "GMT+8:00";

    /**
     * 北京时区別名
     */
    public static final String BJ_TIME_ZONE_ALIAS = "CTT";

    /**
     * 北京时区別名展示
     */
    public static final String BJ_TIME_ZONE_ALIAS_SHOW = "GMT+8";

    /**
     * 全局日期格式,使用时要指定local Mar 27, 2017 1:58:01 PM
     */
    public static final String GLOBAL_DATE_FORMAT = "MMM d, yyyy h:mm:ss a";

    public static final String GLOBAL_DATE_FORMAT2 = "yyyy-MM-dd HH:mm:ss";

    public static final String GLOBAL_DATE_FORMAT_DAY = "yyyy-MM-dd";

    public static final String GLOBAL_DATE_FORMAT_WITHOUT_DAY = "MMM, yyyy";

    public static final String GLOBAL_DATE_FORMAT_WITHOUT_HOUR = "MMM d, yyyy";

    public static final int HALF_HOUR_SECONDS = 30 * 60;

    /**
     * SILK语言集合(包括：0英文, 1中文)
     */
    public static final List<String> SILK_LANGUAGE_COLLECTION = Arrays.asList(SILK_LANGUAGE01_EN, SILK_LANGUAGE01_CN);

    /**
     * 表base_region中国家的REGION_PARENT_ID值
     */
    public static final Long REGION_PARENT_ID = 0L;

    /**
     * 默认的地区ID
     */
    public static final Long DEFAULT_COUNTRY_ID = 0L;
    public static final Long DEFAULT_PROVINCE_ID = 0L;

    /**
     * 国家ID
     */
    public static final Long USA_REGION_ID = 88461L;
    public static final Long CHINA_REGION_ID = 89251L;
    public static final Long TAIWAN_REGION_ID = 122201L;
    public static final Long MACAU_REGION_ID = 132941L;
    public static final Long HONG_KONG_REGION_ID = 121991L;
    public static final Long MALAYSIA_REGION_ID = 133061L;

    /**
     * 系统参数表各个州对应的type值
     */
    public static final String PARAM_REGION_TYPE = "PARAM_REGION_TYPE";

    /**
     * 忽略报警的异常
     */
    public static final Set<String> IGNORE_EXCEPTION_CLASS_NAME_SET = new HashSet<String>(10);

    static {
        IGNORE_EXCEPTION_CLASS_NAME_SET.add("org.apache.catalina.connector.ClientAbortException");
    }

    /**
     * 新老通用标志：1-新；0-老
     */
    public static final String NEW_FLAG = "1";
    public static final String OLD_FLAG = "0";
}
