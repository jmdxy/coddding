package com.mycode.designpattern.filterchain;

/**
 * @author zhangxu
 */
public interface Filter {

    Response doChain(MyService myService, Request request);

}
