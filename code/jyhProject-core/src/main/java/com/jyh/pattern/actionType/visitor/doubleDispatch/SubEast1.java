package com.jyh.pattern.actionType.visitor.doubleDispatch;

public class SubEast1 extends East{

    @Override
    public void goEast(West west) {
        west.goWest1(this);
    }

    public String getName1(){
        return "SubEast1";
    }
}
