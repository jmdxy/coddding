package com.mycode.javassist.impl;

import com.mycode.javassist.HelloService;

/**
 * @author zhangxu
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hi(String input) {
        return input;
    }
}
