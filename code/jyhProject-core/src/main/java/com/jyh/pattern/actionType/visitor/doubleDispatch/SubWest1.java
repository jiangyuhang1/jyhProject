package com.jyh.pattern.actionType.visitor.doubleDispatch;

public class SubWest1 extends West{

    @Override
    public void goWest1(SubEast1 east) {
        System.out.println("SubWest1 + " + east.getName1());
    }

    @Override
    public void goWest2(SubEast2 east) {
        System.out.println("SubWest1 + " + east.getName2());
    }
}
