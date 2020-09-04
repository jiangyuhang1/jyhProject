package com.jyh.spring.springBean;

public class EmptyClass {
    static {
        System.out.println("Enter EmptyClass.static block");
    }

    public EmptyClass() {
        System.out.println("Enter EmptyClass.construct()");
    }

    public void init() {
        System.out.println("Enter EmptyClass.init()");
    }

    public void destory() {
        System.out.println("Enter EmptyClass.destory()");
    }
}
