package com.jyh.pattern.structType.adapter.classAdapter;

/**
 * 概要: 1.适配器角色就是把源对象和目标对象的功能结合在一起,通过适配器把源目标转换成可以实现目标对象的功能
 *      2.这是一个类适配器模式
 */
public class AdapterTest {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.print1();
        adapter.print2();
    }
}
