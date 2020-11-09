package com.jyh.pattern.factory.abstracted;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        /**
         * 使用具体的工厂去生产对象
         */
        AbstractFactory abstractFactory = new MengNiuFactory();
        abstractFactory.getMilk().getName();
    }
}
