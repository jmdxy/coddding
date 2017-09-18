package com.mycode.nio.nio.netty;

import com.mycode.nio.nio.netty.server.PbrpcServer;


public class PbrpcServerTest {
    
    public static void main(String[] args) {
        PbrpcServer server = new PbrpcServer(8088);
        server.start();
    }
    
}
