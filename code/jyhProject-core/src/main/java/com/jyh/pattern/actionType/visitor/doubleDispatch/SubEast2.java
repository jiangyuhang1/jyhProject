package com.jyh.pattern.actionType.visitor.doubleDispatch;

public class SubEast2 extends East{

    @Override
    public void goEast(West west) {
        west.goWest2(this);
    }

    public String getName2(){
        return "SubEast2";
    }
}
