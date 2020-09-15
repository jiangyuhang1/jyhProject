package com.jyh.multiThread.thread.staticMethod;

//测试sleep方法
//让当前的执行的线程暂停执行,当前线程指的是Thread.currentThread返回的线程
//该线程不丢失任何监视器的所属权
public class TestSleep extends Thread{

    @Override
    public void run() {
        System.out.println("run begin");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //打印这句离上句有两秒钟延迟
        System.out.println("run end");
    }

    public static void main(String[] args){
        TestSleep ts = new TestSleep();
        ts.start();
    }
}
