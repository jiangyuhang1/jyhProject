package com.jyh.multiThread.synchronization;

//测试synchronized重入锁
//当一个线程获得一个对象锁的时候，在此请求获取对象锁的时候可以再次得到改对象的锁
//锁重入机制也可以在父子继承的关系中体现
public class TestReentryLock {
    public synchronized void print1(){
        System.out.println("print1");
        print2();
    }

    public synchronized void print2(){
        System.out.println("print2");
        print3();
    }

    public synchronized void print3(){
        System.out.println("print3");
    }

    public static void main(String[] args){
        TestReentryLock1 trl = new TestReentryLock1();
        trl.start();
    }
}


class TestReentryLock1 extends Thread{

    @Override
    public void run() {
        TestReentryLock trl = new TestReentryLock();
        trl.print1();
    }
}
