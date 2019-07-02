package com.ayyovei.simplewebserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/7/3
 */
public class HttpProcessor {

    public void process(Socket socket) {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            Request request = new Request(inputStream);
            request.parse();
            System.out.println(request.getFullRequestMsg());
            System.out.println(request.getUri());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
