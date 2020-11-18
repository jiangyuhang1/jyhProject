package com.jyh.pattern.structType.adapter.objectAdater;

/**
 * 对象适配器模式，适配器角色
 */
public class ObjectAdapter {
    /**
     * 持有源目标的引用
     */
    private ObjectAdaptee oa;

    public ObjectAdapter(ObjectAdaptee oa){
        this.oa = oa;
    }

    public void print1(){
        this.oa.print1();
    }

    /**
     * 为到达目标对象的功能，而需要提供的方法
     */
    public void print2(){
        System.out.println("这是适配器适配的新方法");
    }
}
