package com.study.util.string;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;

public class StringUtils {
    public static String trimRight(String str, char c) {
        if (Strings.isNotBlank(str) && str.charAt(str.length() - 1) == c) {
            return trimRight(str.substring(0, str.length() - 1), c);
        }
        return str;
    }

    private static String getRequestURL(String url) {
        String requestURL = url;
        if (requestURL.indexOf("www.doba.com/doba-com") != -1) {
            return requestURL.replace("www.doba.com/doba-com", "www.doba.com");
        }
        else if (requestURL.indexOf("dropshipping.crov.com/dropshipping-channel") != -1) {
            return requestURL.replace("dropshipping.crov.com/dropshipping-channel", "dropshipping.crov.com");
        }
        else {
            return requestURL;
        }
    }

    private static String trimeRequestSchema(String uri){
        if(uri.startsWith("https://")){
            return uri.substring(8);
        }else if(uri.startsWith("http://")){
            return uri.substring(7);
        }
        return uri;
    }

    public static void main(String[] args) {
        System.out.println(trimRight("",'/'));
        System.out.println(trimRight(null,'/'));
        System.out.println(trimRight("http://222.com/aaa",'/'));
        System.out.println(trimRight("http://222.com/aaa///",'/'));

        System.out.println(trimeRequestSchema("httpd://www.baidu.com"));
        System.out.println(trimeRequestSchema("https://www.baidu.com"));

        System.out.println(getRequestURL("http://www.doba.com/doba-com/aa/"));
        System.out.println(getRequestURL("http://dropshipping.crov.com/dropshipping-channel/aab/"));
    }
}
