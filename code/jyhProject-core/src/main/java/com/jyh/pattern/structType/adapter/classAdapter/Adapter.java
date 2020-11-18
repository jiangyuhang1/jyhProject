package com.jyh.pattern.structType.adapter.classAdapter;

/**
 * 适配器模式，适配器角色
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void print2() {
        System.out.println("这个是实现目标的方法");
    }
}
