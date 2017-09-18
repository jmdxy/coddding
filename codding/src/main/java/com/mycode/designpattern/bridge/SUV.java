package com.mycode.designpattern.bridge;

/**
 * @author zhangxu
 */
public class SUV implements Car {

    @Override
    public void drive() {
        System.out.print("SUV");
    }

}
