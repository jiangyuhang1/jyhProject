package com.jyh.spring.bean;

public class SingletonClass1 {
    //SingletonClass1 instance = new SingletonClass1();
    private SingletonClass1 instance;

    public SingletonClass1 getInstance() {
        return new SingletonClass1();
    }
}
