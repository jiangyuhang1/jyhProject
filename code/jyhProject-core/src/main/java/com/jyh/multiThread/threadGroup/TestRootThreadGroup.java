package com.jyh.multiThread.threadGroup;


/**
 * 测试根线程组，根线程是system
 */
public class TestRootThreadGroup {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());
    }
}
