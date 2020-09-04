package com.jyh.spring.bean;

public class SingletonClass {
    private static SingletonClass instance = new SingletonClass();

    private SingletonClass(){}

    public static SingletonClass getInstance() {
        return instance;
    }
}
