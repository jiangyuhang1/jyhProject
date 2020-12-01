package com.jyh.pattern.actionType.visitor.doubleDispatch;

/**
 * 双重分派
 * 概述: java不支持动态的多分派，使用设计模式可以实现
 */
public class DoubleDispatchClient {

    public static void main(String[] args) {
        //组合1
        East east = new SubEast1();
        West west = new SubWest1();

        /**
         * 1.调用goEast方法是一次动态分派，这里是调用SubEast1对象下面的goEast方法
         * 2.传入west对象，内部调用goWest1()方法，此时是一次动态分配，调用的是SubWest1对象下面的
         *   goWest1方法
         */
        east.goEast(west);
        //组合2
        east = new SubEast1();
        west = new SubWest2();
        east.goEast(west);
    }
}
