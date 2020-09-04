package com.jyh.spring.springBean;

public class SingletonClass {
    private static SingletonClass instance = new SingletonClass();

    private SingletonClass(){}

    public static SingletonClass getInstance() {
        return instance;
    }
}
