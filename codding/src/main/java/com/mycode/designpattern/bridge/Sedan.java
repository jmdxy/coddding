package com.mycode.designpattern.bridge;

/**
 * @author zhangxu
 */
public class Sedan implements Car {

    @Override
    public void drive() {
        System.out.print("小轿车");
    }

}
