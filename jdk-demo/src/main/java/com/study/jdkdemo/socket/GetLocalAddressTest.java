package com.study.jdkdemo.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class GetLocalAddressTest {
    public static void main(String[] args) throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("www.baidu.com",80);

        Socket socket = new Socket();
        socket.connect(socketAddress,1000);
        String hostToBind = socket.getLocalAddress().getHostAddress();
        System.out.println(hostToBind);
        System.out.println(socket.getLocalAddress());
        System.out.println(socket.getLocalSocketAddress());

        SocketChannel socketChannel= SocketChannel.open(socketAddress);
        System.out.println(socketChannel.getLocalAddress());
        System.out.println(socketChannel.getRemoteAddress());
        System.out.println(socketChannel.isConnected());
    }
}
