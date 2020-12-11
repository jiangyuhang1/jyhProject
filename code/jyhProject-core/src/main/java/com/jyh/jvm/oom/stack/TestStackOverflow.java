package com.jyh.jvm.oom.stack;

/**
 * 测试栈溢出案例
 * 说明：1、此案例测试栈的深度过高导致栈溢出
 * 2、不断创建线程导致栈溢出在Windows系统可能会造成系统假死，因为java线程是直接映射到Windows内核空间的
 * 参数：-Xss128k
 */
public class TestStackOverflow {
    private int stackLength = 0;

    public void stackTest(){
        stackLength++;
        stackTest();
    }

    public static void main(String[] args) {
        TestStackOverflow testStackOverflow = new TestStackOverflow();
        try {
            testStackOverflow.stackTest();
        }catch (Error e){
            System.out.println(testStackOverflow.stackLength);
            e.printStackTrace();
        }
    }
}
