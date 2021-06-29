package com.study.util.string;

import org.apache.logging.log4j.util.Strings;

public class StringUtils {
    public static String trimRight(String str, char c) {
        if (Strings.isNotBlank(str) && str.charAt(str.length() - 1) == c) {
            return trimRight(str.substring(0, str.length() - 1), c);
        }
        return str;
    }


}
