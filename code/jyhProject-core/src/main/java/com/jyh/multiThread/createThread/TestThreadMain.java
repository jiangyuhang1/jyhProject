package com.jyh.multiThread.createThread;

public class TestThreadMain {
    //在Thread 有六种状态
    //新建状态NEW:new出实例的线程
    //可运行状态RUNNABLE:调用start方法的线程
    //阻塞BLOCKED:
    //等待WAITING:
    //超时等待TIMED_WAITING:
    //终止状态TERMINATED:线程终止或者run方法执行结束
    public static void main(String[] args){
        RunnableDemo rd = new RunnableDemo();
        RunnableDemo rd1 = new RunnableDemo();
        //实现Runnable接口创建多线程启动需要调用Thread实例启动
        //通过Thread的实例就会创建出来一个线程
        Thread tr = new Thread(rd);
        Thread tr1 = new Thread(rd1);
        //tr.start();
        //tr1.start();

        ThreadDemo td = new ThreadDemo();
        ThreadDemo td1 = new ThreadDemo();
        td.start();
        td1.start();
    }
}
