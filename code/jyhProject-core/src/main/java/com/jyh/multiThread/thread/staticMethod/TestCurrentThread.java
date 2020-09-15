package com.jyh.multiThread.thread.staticMethod;

//测试currentThread()方法
//当前正在运行的线程
//this代表是线程实例，currentThread()是当前正在执行的线程
public class TestCurrentThread extends Thread{
    static{
        //main
        System.out.println(Thread.currentThread().getName());
    }

    public TestCurrentThread(){
        //main
        System.out.println(Thread.currentThread().getName());
        //thread-0
        System.out.println(this.getName());
    }

    @Override
    public void run(){
        //Thread-0
        System.out.println(Thread.currentThread().getName());
        //Thread-0
        System.out.println(this.getName());
    }


    public static void main(String[] args){
        //静态代码块和构造函数是由main线程执行的,run方法才是由自己的线程执行的
        TestCurrentThread tc = new TestCurrentThread();
        tc.start();
    }
}
