package com.ayyovei.simplewebserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/7/3
 */
public class HttpConnector implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            Socket accept = serverSocket.accept();
            new HttpProcessor().process(accept);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
