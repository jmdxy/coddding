package com.mycode.designpattern.bridge.enhancement;

import com.mycode.designpattern.bridge.Road;

/**
 * @author zhangxu
 */
public class Women extends AbstractPerson implements Person {

    public Women(Road road) {
        super(road);
    }

    @Override
    public void work() {
        System.out.print("女人");
        super.work();
        road.run();
    }
}

