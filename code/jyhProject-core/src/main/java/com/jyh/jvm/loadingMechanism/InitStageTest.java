package com.jyh.jvm.loadingMechanism;

/**
 * 测试初始化阶段被动引用场景
 * 1.子类引用父类静态字段，不会导致子类初始化
 * 2.通过数组定义引用类，不会触发此类的初始化
 * 3.引用静态常量时，常量在编译阶段会存入类的常量池中，本质上并没有直接引用到定义常量的类
 */
public class InitStageTest {
    public final static int value = 123;
    static {
        System.out.println("SuperClass init");
    }
}

class TestMain {
    public static void main(String[] args) {
        System.out.println(InitStageTest.value);
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
