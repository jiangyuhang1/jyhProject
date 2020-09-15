package com.jyh.multiThread.thread.staticMethod;

//测试interrupted方法
public class TestInterrupted {
    public static void main(String[] args)
    {
        Thread.currentThread().interrupt();
        //测试当前线程是否已经中断，执行后具有将状态标识清除为false的功能。换句话说，如果连续两次调用该方法，那么返回的必定是false
        System.out.println("是否停止1？" + Thread.interrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
        System.out.println("end!");
    }
}
