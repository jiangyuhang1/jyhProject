package com.jyh.pattern.structType.adapter.objectAdater;

/**
 * 对象适配器测试类
 */
public class ObjectAdapterTest {

    public static void main(String[] args) {
        ObjectAdaptee oa = new ObjectAdaptee();
        ObjectAdapter objectAdapter = new ObjectAdapter(oa);

        objectAdapter.print1();
        objectAdapter.print2();
    }
}
