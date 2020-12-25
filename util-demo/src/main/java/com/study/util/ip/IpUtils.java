package com.study.util.ip;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class IpUtils {

    /**
     * IP(V4)正则表达式
     */
    public final static Pattern IP_V4_PATTERN = Pattern.compile("^[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}$");

    /**
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        try {
            Boolean reverseProxyOpen = true;
            if (reverseProxyOpen == null || Boolean.FALSE.equals(reverseProxyOpen)) {
                return request.getRemoteAddr();
            }
            String ip = request.getHeader("X-Forwarded-For");
            if (isIpUnknown(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (isIpUnknown(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (isIpUnknown(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (isIpUnknown(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (isIpUnknown(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip;
        } catch (Exception e) {
            return "127.0.0.1";
        }

    }

    /**
     * @param ip
     * @return
     */
    public static boolean isIpUnknown(String ip) {
        return StringUtils.isBlank(ip) || !IpUtils.IP_V4_PATTERN.matcher(ip).matches()
                || "unknown".equalsIgnoreCase(ip);
    }
}
