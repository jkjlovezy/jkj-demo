package com.study.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress example1 = InetAddress.getByName("maven.mic.com");
        System.out.println(example1); //maven.mic.com/192.168.28.185
        System.out.println(example1.getHostName());//maven.mic.com
        System.out.println(example1.getHostAddress());//192.168.28.185
    }
}
