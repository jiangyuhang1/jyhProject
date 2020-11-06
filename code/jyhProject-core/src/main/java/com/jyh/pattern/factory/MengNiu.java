package com.jyh.pattern.factory;

/**
 * 具体需要生产的产品
 */
public class MengNiu implements Milk {

    @Override
    public void getName() {
        System.out.println("蒙牛!");
    }
}
