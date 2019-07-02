package com.ayyovei.simplewebserver;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/7/3
 */
public class BootStrap {

    public static void main(String[] args) {
        new Thread(new HttpConnector()).start();
    }
}
