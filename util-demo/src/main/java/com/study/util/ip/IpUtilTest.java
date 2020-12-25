package com.study.util.ip;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;

public class IpUtilTest {
    public static void main(String[] args) throws Exception {
        IpUtil ipUtil = new IpUtil();
        ipUtil.setResource(new ClassPathResource("ip/17monipdb.datx"));
        ipUtil.initialize();
        //Arrays.stream(Optional.ofNullable(ipUtil.getLocationInfo("112.80.248.75")).orElseGet(() -> new String[]{})).forEach(System.out::println);
        Arrays.stream(Optional.ofNullable(ipUtil.getLocationInfo("153.101.141.72")).orElseGet(() -> new String[]{})).forEach(System.out::println);
    }
}
